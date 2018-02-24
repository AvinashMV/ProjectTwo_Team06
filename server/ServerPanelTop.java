package server;

//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * 
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Rishab Mantri (#69)
 */
public class ServerPanelTop extends JPanel implements ActionListener {
	JButton serverControlButton;
	MessageObservable observable;
	ServerSocketMain serverSocketMain = MessageHandler.getInstance().getServerSocketMain();
	ExecutorService executor = Executors.newFixedThreadPool(10);
	InputObservable inputObservable;
	FrequencyObservable frequencyObservable;

	public ServerPanelTop() {
		inputObservable = new InputObservable();
		observable = new MessageObservable();
		frequencyObservable = new FrequencyObservable();
		
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		JLabel test = new JLabel("TOP");
		serverControlButton = new JButton();
		test.setPreferredSize(new Dimension(600, 50));
		setBackground(StandardColor.LIGHT_BLUE);
		serverControlButton.setText("Start");
		serverControlButton.setBackground(Color.PINK);
		serverControlButton.addActionListener(this);
		add(test);
		add(serverControlButton);
		observable.addObserver(MessageHandler.getInstance().getServerStatusPanel());
		observable.addObserver(MessageHandler.getInstance().getServerPanelConsole());
		inputObservable.addObserver(MessageHandler.getInstance().getServerPanelConsole());
		frequencyObservable.addObserver(MessageHandler.getInstance().getServerSocketMain());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		if (button.getText().equals("Start")) {
			if(!performInputValidation()) {
				return;
			}
			
			button.setText("Stop");
			startServer();
			observable.changeData("Start");
		} else {
			button.setText("Start");
			observable.changeData("Stop");
			stopServer();
		}

	}

	private boolean performInputValidation() {
		JFormattedTextField frequency = ServerDataHandler.getInstance().getFrequency();
		JFormattedTextField highText =  ServerDataHandler.getInstance().getHighTxt();
		JFormattedTextField lowText =  ServerDataHandler.getInstance().getLowText();
		try {
			int frequencyVal = Integer.parseInt(frequency.getText().replace(",",""));
			int highValue = Integer.parseInt(highText.getText().replace(",",""));
			int lowValue = Integer.parseInt(lowText.getText().replace(",",""));
			if(lowValue > highValue) {
				throw new Exception("Low value greater than high valye");
			}
			
			ServerDataManager.getInstance().setHighestValue(highValue);
			ServerDataManager.getInstance().setLowestValue(lowValue);
			frequencyObservable.changeData(String.valueOf(frequencyVal));
			
		}
		catch(NumberFormatException e){
			
			inputObservable.changeData("Please set the arguments properly \n");
			return false;
		}
		catch(Exception e) {
			inputObservable.changeData(e.getMessage());
			return false;
		}
	
		return true;
	}

	private void startServer() {
		Runnable runnableTask = () -> {
			serverSocketMain.startConnection();
		};
		executor.execute(runnableTask);
	}

	private void stopServer() {
		serverSocketMain.closeConnection();
	}

}
