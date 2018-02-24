package client;
import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JComboBox;

/**
 * @author Team 6
 */

public class ClientSocketMain {
	Socket s;
	DataInputStream din;
	DataOutputStream dout;
	BufferedReader br;
	ClientDataManager clientDataManager = ClientDataManager.getInstance();
	boolean flag = true;
	ExecutorService executor = Executors.newFixedThreadPool(10);
	int frequency;

	public void startConnection(int frequency) {
		this.frequency = frequency;
		try {
			s = new Socket("127.0.0.1", 1201);
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			br = new BufferedReader(new InputStreamReader(System.in));
			String msgin = "", msgout = "";
			String channel = getChannelValue();
			while (!msgin.equals("end")) {
				dout.writeUTF(channel);
				msgin = din.readUTF();
				System.out.println(msgin);
				setData(msgin);
				startGraphPlot();
			}
			s.close();
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

	private void setData(String msgin) {
		ArrayList<ArrayList<Integer>> serverData = clientDataManager.getDump();
		String[] data = msgin.split(",");
		for (int i = 0; i < data.length; i++) {
			serverData.get(i).add(Integer.parseInt(data[i]));
		}
	}

	public void closeConnection() {
		try {
			din.close();
			dout.close();
			br.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}