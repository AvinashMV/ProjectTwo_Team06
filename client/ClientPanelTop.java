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

import javafx.beans.Observable;
import server.MessageHandler;
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
	ClientConsoleObserver clientConsoleObserver ; 

	public ClientPanelTop() {
		JPanel clientPanel = new JPanel();
		clientPanel.setPreferredSize(new Dimension(560, 50));
		JButton startStop = new JButton();
		startStop.addActionListener(this);
		startStop.setText(ClientConstants.START);
		startStop.setBackground(Color.pink);
		startStop.setBorder(BorderFactory.createLineBorder(Color.black));
		startStop.setPreferredSize(new Dimension(100, 50));
		clientConsoleObserver = new ClientConsoleObserver();
		clientConsoleObserver.addObserver(ClientDataManager.getInstance().getPanelConsole());
		add(clientPanel);
		add(startStop);
	}

	/*
	 * actionPerformed defines the functionality after start/stop button pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.getText().equals("Start")) {
			int frequency = getValueOfFrequency();
			if(frequency == -1) {
				return;
			}
			button.setText("Stop");
			clientConsoleObserver.changeData("Start");
			clientSocketMain = new ClientSocketMain();
			ClientDataManager.getInstance().initializeArray();
			startServer(frequency);
			
		} else {
			button.setText("Start");
			clientConsoleObserver.changeData("Stop");

			stopServer();
		}

	}


	/*
	 * return value of frequency from data manager
	 */
	private int getValueOfFrequency() {
		JTextPane frequencyTxt = ClientDataManager.getInstance().getFreqText();
		String frequency = frequencyTxt.getText().replace(",","");
		try {
			Integer freq = Integer.parseInt(frequency);
			if(freq <=0) {
				throw new NumberFormatException();
			}
			return freq;
		}
		catch(NumberFormatException e) {
			clientConsoleObserver.changeData("Please enter a valid frequency \n");
			return -1;
		}
		
		
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