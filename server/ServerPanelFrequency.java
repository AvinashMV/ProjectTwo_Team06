package server;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The ServerPanelConsole class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerPanelFrequency extends JPanel implements ActionListener {

	JPanel frequencyPanel;
	JLabel frequencyLabel;
	JFormattedTextField frequencyTxt;
	int frequency;
	FrequencyObservable observable;

	/*
	 * Sets the observables for frequency setting and passing
	 * 
	 */
	public ServerPanelFrequency() {
		frequencyPanel = new JPanel();
		frequencyLabel = new JLabel(ServerConstants.FREQUENCY_LABEL);
		frequencyLabel.setFont(ServerConstants.TEXT_FONT);
		frequencyLabel.setSize(85, 60);
		frequencyPanel.setPreferredSize(new Dimension(120, 60));
		frequencyPanel.setBackground(ServerConstants.LIGHT_BLUE);
		frequencyPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		frequencyTxt = new JFormattedTextField(ServerHelper.formatter());
		ServerDataHandler.getInstance().setFrequency(frequencyTxt);
		frequencyTxt.setBorder(BorderFactory.createLineBorder(Color.black));
		frequencyTxt.setBackground(ServerConstants.PINK);
		frequencyTxt.setPreferredSize(new Dimension(120, 60));
		frequencyTxt.setEditable(true);
		frequencyTxt.addActionListener(this);
		observable = new FrequencyObservable();
		observable.addObserver(MessageHandler.getInstance().getServerSocketMain());
		add(frequencyPanel);
		frequencyPanel.add(frequencyLabel);
		add(frequencyTxt);
	}

	/*Sends the action performed for the change in data
	 * @param actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JFormattedTextField frequency = (JFormattedTextField) actionEvent.getSource();
		observable.changeData(frequency.getValue());
	}
}
