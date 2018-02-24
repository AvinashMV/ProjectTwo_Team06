package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import server.ServerSocketMain;

/**
 * ClientPanelTop class handles the start stop functionality for client
 * 
 * @author Team 6
 */
public class ClientPanelTop extends JPanel implements ActionListener {

	ServerSocketMain serverSocketMain = new ServerSocketMain();
	ExecutorService executor = Executors.newFixedThreadPool(10);
	ClientSocketMain clientSocketMain;

	public ClientPanelTop() {
		JPanel clientPanel = new JPanel();
		clientPanel.setPreferredSize(new Dimension(560, 50));
		JButton startStop = new JButton();
		startStop.addActionListener(this);
		startStop.setText(ClientConstants.START);
		startStop.setBackground(Color.pink);
		startStop.setBorder(BorderFactory.createLineBorder(Color.black));
		startStop.setPreferredSize(new Dimension(100, 50));
		add(clientPanel);
		add(startStop);
	}

	/*
	 * actionPerformed defines the functionality after start/stop button pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.getText().equals(ClientConstants.START)) {
			clientSocketMain = new ClientSocketMain();
			button.setText(ClientConstants.STOP);
			ClientDataManager.getInstance().initializeArray();
			startServer(getValueOfFrequency());
		} else {
			button.setText(ClientConstants.START);
			stopServer();
		}

	}

	/*
	 * return value of frequency from data manager
	 */
	private int getValueOfFrequency() {
		JTextPane frequencyTxt = ClientDataManager.getInstance().getFreqText();
		String frequency = frequencyTxt.getText();
		Integer freq = Integer.parseInt(frequency);
		return freq;
	}

	/*
	 * start server functionality
	 * 
	 * @param frequency : client frequency count
	 */
	private void startServer(int frequency) {
		Runnable runnableTask = () -> {
			clientSocketMain.startConnection(frequency);
		};
		executor.execute(runnableTask);
	}

	/*
	 * stop server functionality
	 */
	private void stopServer() {
		clientSocketMain.closeConnection();
		executor.shutdown();
	}
}