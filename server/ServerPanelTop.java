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
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		JLabel test = new JLabel("TOP");
		serverControlButton = new JButton();
		test.setPreferredSize(new Dimension(600, 50));
		setBackground(ServerConstants.LIGHT_BLUE);
		serverControlButton.setText("Start");
		serverControlButton.setBackground(Color.PINK);
		serverControlButton.addActionListener(this);
		add(test);
		add(serverControlButton);
		observable = new MessageObservable();
		observable.addObserver(MessageHandler.getInstance().getServerStatusPanel());
		observable.addObserver(MessageHandler.getInstance().getServerPanelConsole());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		if (button.getText().equals("Start")) {
			button.setText("Stop");
			startServer();
			observable.changeData("Start");
		} else {
			button.setText("Start");
			observable.changeData("Stop");
			stopServer();
		}

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
