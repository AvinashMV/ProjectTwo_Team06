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
public class ServerPanelLowest extends JPanel implements ActionListener {

	JPanel lowestValuePanel;
	JLabel lowLabel;
	JFormattedTextField lowTxt;
	int lowestValue;

	/*
	 * Sets observables for the lowest value text
	 */
	public ServerPanelLowest() {
		lowestValuePanel = new JPanel();
		lowLabel = new JLabel(ServerConstants.LOWEST_LABEL);
		lowLabel.setFont(ServerConstants.TEXT_FONT);
		lowLabel.setSize(85, 60);
		lowestValuePanel.setPreferredSize(new Dimension(120, 60));
		lowestValuePanel.setBackground(ServerConstants.PINK);
		lowestValuePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		lowTxt = new JFormattedTextField(ServerHelper.formatter());
		ServerDataHandler.getInstance().setLowText(lowTxt);
		lowTxt.addActionListener(this);
		lowTxt.setBorder(BorderFactory.createLineBorder(Color.black));
		lowTxt.setBackground(ServerConstants.LIGHT_BLUE);
		lowTxt.setPreferredSize(new Dimension(120, 60));
		lowTxt.setEditable(true);
		add(lowestValuePanel);
		lowestValuePanel.add(lowLabel);
		add(lowTxt);
	}

	/*Returns the lowest value observed
	 * @return lowestValue
	 */
	public int getLowestValue() {
		lowestValue = Integer.parseInt(lowTxt.getText());
		return lowestValue;
	}

	/*Sets the value on the lowest text
	 * @param actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JFormattedTextField lowText = (JFormattedTextField) actionEvent.getSource();
		Long low = (Long) lowText.getValue();
		ServerDataManager.getInstance();
		ServerDataManager.setLowestValue(low);
	}
}
