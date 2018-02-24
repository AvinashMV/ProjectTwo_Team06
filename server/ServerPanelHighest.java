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
 * The ServerControlPanel class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerPanelHighest extends JPanel implements ActionListener {

	JPanel highestValuePanel;
	JLabel highLabel;
	JFormattedTextField highTxt;
	int highestValue;

	/*
	 * Sets observables for the highest value text
	 * 
	 * @param actionEvent
	 */
	public ServerPanelHighest() {
		highestValuePanel = new JPanel();
		highLabel = new JLabel(ServerConstants.HIGHEST_LABEL);
		highLabel.setFont(ServerConstants.TEXT_FONT);
		highLabel.setSize(85, 60);
		highestValuePanel.setPreferredSize(new Dimension(120, 60));
		highestValuePanel.setBackground(ServerConstants.LIGHT_BLUE);
		highestValuePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		highTxt = new JFormattedTextField(ServerHelper.formatter());
		ServerDataHandler.getInstance().setHighTxt(highTxt);
		highTxt.addActionListener(this);
		highTxt.setBorder(BorderFactory.createLineBorder(Color.black));
		highTxt.setBackground(ServerConstants.PINK);
		highTxt.setPreferredSize(new Dimension(120, 60));
		highTxt.setEditable(true);
		add(highestValuePanel);
		highestValuePanel.add(highLabel);
		add(highTxt);
	}

	/*
	 * Returns the highest value observed
	 * 
	 * @return highestValue
	 */
	public int getHighestValue() {
		highestValue = Integer.parseInt(highTxt.getText());
		return highestValue;
	}

	/*
	 * @param actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JFormattedTextField highText = (JFormattedTextField) actionEvent.getSource();
		Long high = (Long) highText.getValue();
		ServerDataManager.getInstance();
		ServerDataManager.setHighestValue(high);
	}
}
