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
	boolean flag;

	/*Starts and listens to the connection for the server
	 * 
	 */
	public void startConnection() {
		try {
			serverSocket = new ServerSocket(1201);
			socket = serverSocket.accept();

			dataInputStream = new DataInputStream(socket.getInputStream());

			dataOutputStream = new DataOutputStream(socket.getOutputStream());

			String message = "", msgout = "";
			flag = true;
			while (flag) {
				message = dataInputStream.readUTF();
				if (count < 2) {
					ServerDataManager.getInstance();
					ServerDataManager.setChannels(Integer.parseInt(message));
				}
				Thread.sleep(frequency);
				dataOutputStream.writeUTF(ServerDataManager.getInstance().generateNumbers());
				dataOutputStream.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				dataInputStream.close();
				dataOutputStream.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}



	private void addChannel(String msgin) {
		ServerDataManager.getInstance().setChannels(Integer.parseInt(msgin));
	}

	public void closeConnection() {
		this.flag = false;

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