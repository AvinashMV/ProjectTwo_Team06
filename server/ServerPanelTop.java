package server;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The ServerPanelConsole class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerPanelTop extends JPanel implements ActionListener {
	JButton serverControlButton;
	MessageObservable observable;
	ServerSocketMain serverSocketMain = MessageHandler.getInstance().getServerSocketMain();
	ExecutorService executor = Executors.newFixedThreadPool(10);

	public ServerPanelTop() {
		JLabel topLabel = new JLabel("");
		serverControlButton = new JButton();
		topLabel.setPreferredSize(new Dimension(600, 50));
		setBackground(ServerConstants.LIGHT_BLUE);
		serverControlButton.setText(ServerConstants.START);
		serverControlButton.setBackground(Color.PINK);
		serverControlButton.addActionListener(this);
		add(topLabel);
		add(serverControlButton);
		observable = new MessageObservable();
		observable.addObserver(MessageHandler.getInstance().getServerStatusPanel());
		observable.addObserver(MessageHandler.getInstance().getServerPanelConsole());
	}

	/*
	 * @args actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JButton button = (JButton) actionEvent.getSource();
		if (button.getText().equals(ServerConstants.START)) {
			button.setText(ServerConstants.STOP);
			startServer();
			observable.changeData(ServerConstants.START);
		} else {
			button.setText(ServerConstants.START);
			observable.changeData(ServerConstants.STOP);
			serverSocketMain.closeConnection();
		}
	}

	/*
	 * 
	 */
	private void startServer() {
		Runnable runnableTask = () -> {
			serverSocketMain.startConnection();
		};
		executor.execute(runnableTask);
	}
}
