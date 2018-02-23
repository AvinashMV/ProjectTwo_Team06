import java.io.*;
import java.net.*;
import java.util.Observable;
import java.util.Observer;

public class ServerSocketMain implements Observer {
	
	Socket s;
	ServerSocket ss;
	DataInputStream din;
	DataOutputStream dout;
	BufferedReader br;
	int count = 1;
	int frequency = 2000;
	
	public ServerSocketMain(){
	}
	
	public void startConnection() {
		try {
			ss = new ServerSocket(1201);
			Socket s = ss.accept();
			
			din = new DataInputStream(s.getInputStream());
			
			dout = new DataOutputStream(s.getOutputStream());
	
			String msgin = "", msgout = "";
			while(true) {
				msgin = din.readUTF();
				if(count < 2) {
					addChannel(msgin);
				}
				Thread.sleep(frequency);
				dout.writeUTF(ServerDataManager.getInstance().generateNumbers());
				dout.flush();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private void addChannel(String msgin) {
		ServerDataManager.getInstance().setChannels(Integer.parseInt(msgin));
	}

	public void closeConnection() {
		try {
			din.close();
			dout.close();
			br.close();
			s.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		String freq = (String) arg;
		frequency = Integer.parseInt(freq);
		
	}
}