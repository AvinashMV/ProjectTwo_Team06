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

	/*Starts and listens to the connection for the server
	 * 
	 */
	public void startConnection() {
		try {
			serverSocket = new ServerSocket(1201);
			socket = serverSocket.accept();
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			while (true) {
				String message = dataInputStream.readUTF();
				if (count < 2) {
					ServerDataManager.getInstance();
					ServerDataManager.setChannels(Integer.parseInt(message));
				}
				Thread.sleep(frequency);
				ServerDataManager.getInstance();
				dataOutputStream.writeUTF(ServerDataManager.generateNumbers());
				dataOutputStream.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function to Close the connection
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable observable, Object arg) {
		String freq = (String) arg;
		frequency = Integer.parseInt(freq);
	}
}