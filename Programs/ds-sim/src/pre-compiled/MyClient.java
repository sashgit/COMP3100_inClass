import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient {

  public static void main(String[] args) throws Exception {

    // initialisation of variables for servers and job handling
    Boolean flag = true;
    String largestType = null;
    int largestCore = 0;
    int serverCount = 0;
    int largestServerType = 0;
    int numServersOfLargestType = 0;

    // connection to the server
    Socket s = new Socket("127.0.0.1", 50000);

    // setup the input and output streams
    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    DataOutputStream output = writeBytes("HELO\n");

    // send the HELO message and the auth message
    out.println("HELO"); // Send HELO
    String username = "user.name";
    String authMessage = "AUTH " + username;

    // Send AUTH username
    out.println(authMessage);

    // read server response and store in variable
    String response = in.readLine();

    // start to allocate jobs to servers
    while (true) {
      // send REDY
      out.println("REDY"); // Send REDY
      response = in.readLine(); // Receive a message

      out.println("GETS All");
      response = in.readLine();

      // create an array of string that is stored in parts
      String[] Segement = response.split("\\s+");
      int jobID = Integer.parseInt(Segement[2]);
      int Core = Integer.parseInt(Segement[4]);

      // for loop used to locate the server of the largest type
      // compare (use the compare function to find largest server) the core count and
      // if you find the largest type you assign all jobs to the server of that type
      for (int i = 0; i < nRecs; i++) {
        // Send a GETS message, e.g., GETS All
        // Receive DATA nRecs recSize // e.g., DATA 5 124

        // Receive each record
        response = input.readLine();

        // using the SCHD use the jobID and largest serverType
        String[] jobInfo = response.split(" ");
        int jobId = Integer.parseInt(jobInfo[0]);
        String serverType = Integer.parseInt(jobInfo[1]);
        int coreCount = Integer.parseInt(jobInfo[4]);

        // if the current coreCount on the server is larger
        // then the previous core count then you make that
        // on the largest serverType
        if (coreCount > serverCount) {
          serverType = largestServerType;
          // check to make sure the next server has more cores then the previous one
        }

        // print to server the JobID and the largest Server Type
        out.println("SCHD " + jobID + " " + largestServerType + " 0");
      }

      // Send OK
      output.writeBytes("OK\n");

      // after we have found the server with the largest type we can start allocating
      // jobs to this server
      out.println("SCHD " + jobID + " " + largestServerType + " 0");
    }

    // if we reach a point where the server responds with NONE then
    // the jobs have finished being assigned
    if (response.equals("NONE")) {
      break;
    }

  }
}
