package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ClientConnection class
 * 
 * @author Team 06
 *
 */
public class ClientConnection implements Runnable {
	private Socket clientsocket;
	Map<Integer, ArrayList<Integer>> channelData;
	private int portNumber = 1250;
	private volatile String inputMessage;
	private int channelCount;

	ClientConnection(int channelcount) {
		channelCount = channelcount;
		channelData = new HashMap<Integer, ArrayList<Integer>>();
	}

	public void run() {
		BufferedReader input;
		try {
			clientsocket = new Socket("localhost", portNumber);
			input = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
			out.println(channelCount);
			while ((inputMessage = input.readLine()) != null) {
			}
			clientsocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<Integer, ArrayList<Integer>> getStream() {
		String in = inputMessage;
		String[] inputs = in.split(",");
		ArrayList<Integer> arr;
		for (int i = 0; i < inputs.length; i++) {
			if (channelData.size() >= i)
				arr = channelData.get(i);
			else {
				arr = new ArrayList<Integer>();
			}
			arr.add(Integer.parseInt(inputs[i]));
			channelData.put(i, arr);
		}
		return channelData;
	}
}
