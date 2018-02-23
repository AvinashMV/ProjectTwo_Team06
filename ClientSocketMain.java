import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientSocketMain {
	Socket s;
	DataInputStream din;
	DataOutputStream dout;
	BufferedReader br;
	ClientDataManager clientDataManager  = ClientDataManager.getInstance();
	boolean flag = true; 
	ExecutorService executor = Executors.newFixedThreadPool(10);
	int frequency;
	
	public void startConnection(int frequency) {
		this.frequency = frequency;
		try {
			s = new Socket("127.0.0.1",1201);
			
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());

			br = new BufferedReader(new InputStreamReader(System.in));

			String msgin = "", msgout = "";

			while (!msgin.equals("end")) {
				dout.writeUTF(String.valueOf(1));
				msgin = din.readUTF();
				setData(msgin);
				startGraphPlot();
//				System.out.println(msgin + "Value Received");
				
			}
			s.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void startGraphPlot() {
		if(flag) {
			System.out.println("Client Graph Parser Added");
			this.flag = false;
			Runnable runnableTask = () -> {
				ClientGraphParser graphParser = new ClientGraphParser(frequency);
				graphParser.addData();
			};
			executor.execute(runnableTask);
		}
		
	}

	private void setData(String msgin) {
	ArrayList<ArrayList<Integer>>  serverData = clientDataManager.getDump();
	System.out.println("asfsafasfsa");
		String[] data = msgin.split(",");
		for(int i=0; i< data.length; i++) {
			serverData.get(i).add(Integer.parseInt(data[i]));	
		}
	}

	public void closeConnection() {
		try{
			din.close();
			dout.close();
			br.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}