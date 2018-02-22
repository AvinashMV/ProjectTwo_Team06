/**
 * Author - Rakesh Mohan
 * Program - Function to transfer data through socket.
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;

public class Serversocket {

	private ServerSocket serversocket = null;
	private Socket clientSocket = null;
    private PrintStream output = null;
    
	Serversocket (int frequency){
		
		int sleepTime = 1000/frequency;
	    try {
	    		serversocket = new ServerSocket(1024);
	        }
	        catch (IOException e) {
	           System.out.println(e);
	        }
	    
	    
	    try {
	        clientSocket = serversocket.accept();
	        output = new PrintStream(clientSocket.getOutputStream());
	        
	        while (true) {
	        		
	        		ServerDataManager dataGenerator = ServerDataManager.getInstance(); 
			    	Thread.sleep(sleepTime);
	        		output.println(dataGenerator.generateNumbers()); 
	           }
	        }
	    catch (IOException e) {
	       System.out.println(e);
	    }
	    catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public boolean ServersocketClose() {
	    
	    try {
	        output.close();
	        clientSocket.close();
	        serversocket.close();
	        
	        return true;
	     } 
	     catch (IOException e) {
	        System.out.println(e);
	        return false;
	     }
	}
	 
}
