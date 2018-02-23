import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClientConnection {
	Socket clientsocket;
    Map<Integer,ArrayList<Integer>> hmap;	//HashMap to store values for each channel
    int portNumber= 1250;
    volatile String inputMessage;
    
    ClientConnection(){
        Map<Integer,ArrayList<Integer>> hmap = new HashMap<Integer,ArrayList<Integer>>();
    }
    //call start on new thread
    void start(int channelCount)
    {
    	BufferedReader input;
        try
        {
        	//connect to server
            clientsocket = new Socket("localhost", portNumber);
            input = new BufferedReader(
                        new InputStreamReader(clientsocket.getInputStream()));
            System.out.println("Connected");
            PrintWriter out =
                    new PrintWriter(clientsocket.getOutputStream(), true);
            //send channelCount
            out.println(channelCount);
            while((inputMessage = input.readLine()) != null)
            {
            	           	
            }          
            
            clientsocket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //call getStream after specified frequency to get data
    Map<Integer, ArrayList<Integer>> getStream(){

    	String in = inputMessage;
    	String []inputs = in.split(",");
    	ArrayList<Integer> arr;
    	for (int i = 0; i < inputs.length; i++) {
			if(hmap.size() >= i)
				arr = hmap.get(i);
			else
			{
				arr = new ArrayList<Integer>();
			}
			arr.add(Integer.parseInt(inputs[i]));
			hmap.put(i, arr);
		}
    	return hmap;
    	
    }
    

}
