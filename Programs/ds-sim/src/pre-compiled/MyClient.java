import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient {

  public static void main(String[] args) throws Exception {

    // initialization of variables for servers and job handling
    // flag ensures largest server is only found once
    boolean flag = true;
    String largestType = null;
    int largestCore = 0;
    int largestServerID = 0;

    // connection to the server
    Socket socket = new Socket("127.0.0.1", 50000);

    // setup the input and output streams
    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    DataOutputStream output = new DataOutputStream(socket.getOutputStream());

    // send the HELO message and the auth message
    output.writeBytes("HELO\n"); // Send HELO
    String username = "user.name";
    String authMessage = "AUTH " + username;

    // Send AUTH username
    output.writeBytes(authMessage + "\n");

    // read server response and store in variable
    String response = input.readLine();

    // start to allocate jobs to servers
    while (flag) {
      // send REDY
      output.writeBytes("REDY\n"); // Send REDY
      response = input.readLine(); // Receive a message

      if (response.equals("NONE")) {
        break;
      } else if (response.equals("JCPL")) {
        continue;
      } else {
        output.writeBytes("GETS All\n");
        response = input.readLine();

        // create an array of string that is stored in parts
        String[] segments = response.split("\\s+");
        int jobID = Integer.parseInt(segments[2]);
        int nRecs = Integer.parseInt(segments[1]);

        // for loop used to locate the server of the largest type
        // compare (use the compare function to find largest server) the core count and
        // if you find the largest type you assign all jobs to the server of that type
        for (int i = 0; i < nRecs; i++) {
          // Send a GETS message, e.g., GETS All
          // Receive DATA nRecs recSize // e.g., DATA 5 124

          // Receive each record
          response = input.readLine();

          // using the SCHD use the jobID and largest serverType
          String[] jobSplit = response.split(" ");
          int coreCount = Integer.parseInt(jobSplit[4]);

          // if the current coreCount on the server is larger
          // then the previous core count then you make that
          // on the largest serverType
          if (coreCount > largestCore) {
            // check to make sure the next server has more cores then the previous one
            largestCore = coreCount;
            largestType = jobSplit[1];
            largestServerID = Integer.parseInt(jobSplit[2]);
          }
        }

        // print to server the JobID and the largest Server Type
        output.writeBytes("SCHD " + jobID + " " + largestType + " " + largestServerID + "\n");
        response = input.readLine(); // Receive a message
      }
    }

    // close the socket as jobs have been scheduled
    socket.close();
  }
}
