import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient.java
{

  public static void main(String[] args) throws Exception {

    Boolean flag = true;
    String largestType = null;
    int largestCore = 0;
    int serverCount = 0;
    int largestServerType = 0;
    int numServersOfLargestType = 0;
   
    Socket s = new Socket("127.0.0.1", 50000);
   
    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    DataOutputStream output = writeBytes("HELO\n");
       
      out.println("HELO"); // Send HELO
        String username = "user.name";
        String authMessage = "AUTH " + username;
        out.println(authMessage); // Send AUTH username

        String response = in.readLine();
        System.out.println("Server says: " + response);
   
    while(true){
    // send REDY
    out.println("REDY"); // Send REDY
            response = in.readLine(); // Receive a message
           
           // recieve JOBN
           // Send GETS
           // use gets by requesting server information
           out.println("GETS All");
           response = in.readLine();
           
           String[] parts = response.split("\\s+");
           int jobID = Integer.parseInt(parts[2]);
           int estRunTime = Integer.parseInt(parts[3]);
           int core = Integer.parseInt(parts[4]);
           int mem = Integer.parseInt(parts[5]);

    // for loop used to locate the server of the largest type
    // compare (use the compare function to find largest server) the core count and if you find the largest type you assign   all jobs to the server of that type
    for(int i = 0; i < nRecs; i++){
    //  Send a GETS message, e.g., GETS All

    //  Receive DATA nRecs recSize // e.g., DATA 5 124


    // Receive each record
    response = input.readLine();


    String[] jobInfo = response.split(" ");
    int jobId = Integer.parseInt(jobInfo[0]);
    int arrivalTime = Integer.parseInt(jobInfo[1]);
    int estRuntime = Integer.parseInt(jobInfo[2]);
    int coreCount = Integer.parseInt(jobInfo[4]);
    // int memSize = Integer.parseInt(jobInfo[5]);
    // int diskSize = Integer.parseInt(jobInfo[6]);
    out.println("SCHD " + jobID + " " + largestServerType + " 0");


    


    // Keep track of the largest server type and the number of servers of that type

    // End For
  }

    // Send OK
    output.writeBytes("OK\n");

    // Receive




    // If the message received at Step 10 is JOBN then
    // Schedule a job // SCHD
    
  
   
   
   
    // after we have found the server with the largest type we can start allocating jobs to this server
    out.println("SCHD " + jobID + " " + largestServerType + " 0");
            }
       }
}
