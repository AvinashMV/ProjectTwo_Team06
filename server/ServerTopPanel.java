package server;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The ServerTopPanel class
 * 
 * @author
 * @version 1.0
 */
public class ServerTopPanel extends JPanel implements ActionListener {
	JButton serverControlButton;
	MessageObservable observable;

	void createAndShowGUI() {
		JLabel test = new JLabel();
		serverControlButton = new JButton();
		test.setPreferredSize(new Dimension(600, 50));
		this.setBackground(ServerConstants.LIGHT_BLUE);
		serverControlButton.setText(ServerConstants.START);
		serverControlButton.setFont(ServerConstants.TEXT_FONT);
		serverControlButton.setPreferredSize(new Dimension(100, 50));
		serverControlButton.setBackground(Color.PINK);
		serverControlButton.addActionListener(this);
		this.add(test);
		this.add(serverControlButton);
		observable = new MessageObservable();
		observable.addObserver(MessageHandler.getInstance().getServerStatusPanel());
		observable.addObserver(MessageHandler.getInstance().getServerPanelConsole());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.getText().equals(ServerConstants.START)) {
			button.setText(ServerConstants.STOP);
			observable.changeData(ServerConstants.START);
		} else {
			button.setText(ServerConstants.START);
			observable.changeData(ServerConstants.STOP);
		}
	}
}
