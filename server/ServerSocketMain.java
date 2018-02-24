package server;

import java.io.*;
import java.net.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The ServerPanelConsole class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerSocketMain implements Observer {

	Socket socket;
	ServerSocket serverSocket;
	DataInputStream dataInputStream;
	DataOutputStream dataOutputStream;
	BufferedReader bufferedReader;
	int count = 1;
	int frequency = 2000;

	public void startConnection() {
		try {
			serverSocket = new ServerSocket(1201);
			socket = serverSocket.accept();
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			String msgin = "", msgout = "";
			while (true) {
				msgin = dataInputStream.readUTF();
				if (count < 2) {
					ServerDataManager.getInstance();
					ServerDataManager.setChannels(Integer.parseInt(msgin));
				}
				Thread.sleep(frequency);
				ServerDataManager.getInstance();
				dataOutputStream.writeUTF(ServerDataManager.generateNumbers());
				dataOutputStream.flush();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void closeConnection() {
		try {
			dataInputStream.close();
			dataOutputStream.close();
			bufferedReader.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		String freq = (String) arg;
		frequency = Integer.parseInt(freq);
	}
}