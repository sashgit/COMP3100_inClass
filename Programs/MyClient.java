    import java.net.*;
    import java.io.*;
    class MyClient{
    public static void main(String args[])throws Exception{
    Socket s= new Socket("localhost",3333);
    //DataInputStream din=new DataInputStream(s.getInputStream());
    BufferReader in = new BufferReader(new BufferReader(new InputStreamReader(socket.getInputStream()));
    DataOutputStream dout= new DataOutputStream(s.getOutputStream());
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

    String str="",str2="";
    while(!str.equals("stop")){
    str=br.readLine();
    dout.write((HELO).getBytes());  
    dout.flush();  
    str2=din.readLine();  
    System.out.println("Server says: "+str2);  
    }  
      
    dout.close();  
    s.close();  
    }}  
