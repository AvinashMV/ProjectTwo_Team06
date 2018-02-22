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

	public static void main (String [] args){
		
		int min = 1;
		int max = 1024;
		Integer randomNum;
		
		ServerSocket serversocket = null;
		Socket clientSocket = null;
	    PrintStream output = null;
	    
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
	        		
	        		randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			    	Thread.sleep(1000);
	        		output.println(randomNum); 
	           }
	        }
	    catch (IOException e) {
	       System.out.println(e);
	    }
	    catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    try {
	        output.close();
	        clientSocket.close();
	        serversocket.close();
	     } 
	     catch (IOException e) {
	        System.out.println(e);
	     }

	}
}
