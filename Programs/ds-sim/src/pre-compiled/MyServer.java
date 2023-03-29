  GNU nano 6.2 MyServer.java          
    import java.net.*;  
    import java.io.*;  
    class MyServer{  
    public static void main(String ar>
    ServerSocket ss=new ServerSocket(>
    Socket s=ss.accept();  
    DataInputStream din=new DataInput>
    DataOutputStream dout=new DataOut>
    BufferedReader br=new BufferedRea>

    String str="",str2="";  
    while(!str.equals("stop")){  
    str=din.readUTF();  
    System.out.println("client says: >
    str2=br.readLine();  
    dout.write(str2);  
    dout.flush();  
    }  
    din.close();  
    s.close();  
    ss.close();  
    }}  
