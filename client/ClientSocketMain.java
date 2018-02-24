package client;

import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JComboBox;

/**
 * 
 * @author Team 6
 */

public class ClientSocketMain {
	Socket socket;
	DataInputStream dataInputStream;
	DataOutputStream dataOutputStream;
	ClientDataManager clientDataManager = ClientDataManager.getInstance();
	boolean flag = true;
	ExecutorService executor = Executors.newFixedThreadPool(10);
	int frequency;

	/* Sets the input stream from server
	@params frequency
	*/
	public void startConnection(int frequency) {
		this.frequency = frequency;
		try {
			socket = new Socket("127.0.0.1", 1201);
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			String msgin = "", msgout = "";
			String channel = getChannelValue();
			while (!msgin.equals("end")) {
				dataOutputStream.writeUTF(channel);
				msgin = dataInputStream.readUTF();

				setData(msgin);
				startGraphPlot();
			}
			socket.close();
		} catch (Exception e) {
		}
	}

	private String getChannelValue() {
		JComboBox comboBox = clientDataManager.getChannelDD();
		String channel = (String) comboBox.getSelectedItem();
		return channel;

	}

	private void startGraphPlot() {
		if (flag) {
			this.flag = false;
			Runnable runnableTask = () -> {
				ClientGraphParser graphParser = new ClientGraphParser(frequency);
				graphParser.addData();
			};
			executor.execute(runnableTask);
		}
	}
	
	/* Sets the input stream from server
	@params msgin
	*/
	private void setData(String msgin) {
		ArrayList<ArrayList<Integer>> serverData = clientDataManager.getDump();
		String[] data = msgin.split(",");
		for (int i = 0; i < data.length; i++) {
			serverData.get(i).add(Integer.parseInt(data[i]));
		}
	}

	public void closeConnection() {
		try {
			dataInputStream.close();
			dataOutputStream.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}