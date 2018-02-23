package server;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The ServerControlPanel class
 * 
 * @author
 * @version 1.0
 */
public class ServerControlPanel extends JPanel {
	private JPanel highestValuePanel;
	private JPanel lowestValuePanel;
	private JPanel frequencyValuePanel;
	private JLabel highestLabel;
	private JLabel lowestLabel;
	private JLabel frequencyLabel;
	private JFormattedTextField highestText;
	private JFormattedTextField lowestText;
	private JFormattedTextField frequencyText;
	private HashMap<String, String> boundaryValues = new HashMap<>();

	public ServerControlPanel() {
		highestValuePanel = new JPanel();
		lowestValuePanel = new JPanel();
		frequencyValuePanel = new JPanel();
		highestLabel = new JLabel(ServerConstants.HIGHEST_LABEL);
		lowestLabel = new JLabel(ServerConstants.LOWEST_LABEL);
		frequencyLabel = new JLabel(ServerConstants.FREQUENCY_LABEL);
		highestText = new JFormattedTextField(ServerHelper.formatter());
		lowestText = new JFormattedTextField(ServerHelper.formatter());
		frequencyText = new JFormattedTextField(ServerHelper.formatter());
		this.setBackground(ServerConstants.SLATE_GREY);
		this.setLayout(new GridLayout(3, 2));
	}

	void createAndShowGUI() {
		highestLabel.setFont(ServerConstants.TEXT_FONT);
		highestLabel.setPreferredSize(ServerConstants.LABEL_DIMENSION);
		highestValuePanel.setPreferredSize(ServerConstants.TEXT_DIMENSION);
		highestValuePanel.setBackground(ServerConstants.LIGHT_BLUE);
		highestValuePanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// added text panel where the highest value will go.

		// highestText.setText("1024");
		highestText.setBorder(BorderFactory.createLineBorder(Color.black));
		highestText.setBackground(ServerConstants.PINK);
		highestText.setPreferredSize(ServerConstants.TEXT_DIMENSION);
		highestText.setEditable(true);
		this.add(highestValuePanel);
		highestValuePanel.add(highestLabel);
		this.add(highestText);

		// lowest
		lowestLabel.setFont(ServerConstants.TEXT_FONT);
		lowestLabel.setPreferredSize(ServerConstants.LABEL_DIMENSION);
		lowestValuePanel.setPreferredSize(ServerConstants.TEXT_DIMENSION);
		lowestValuePanel.setBackground(ServerConstants.LIGHT_BLUE);
		lowestValuePanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// lowestText.setText("0");
		lowestText.setBorder(BorderFactory.createLineBorder(Color.black));
		lowestText.setBackground(ServerConstants.PINK);
		lowestText.setPreferredSize(ServerConstants.TEXT_DIMENSION);
		lowestText.setEditable(true);
		this.add(lowestValuePanel);
		lowestValuePanel.add(lowestLabel);
		this.add(lowestText);

		// frequency
		frequencyLabel.setFont(ServerConstants.TEXT_FONT);
		frequencyLabel.setPreferredSize(ServerConstants.LABEL_DIMENSION);
		frequencyValuePanel.setPreferredSize(ServerConstants.TEXT_DIMENSION);
		frequencyValuePanel.setBackground(ServerConstants.LIGHT_BLUE);
		frequencyValuePanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// frequencyText.setText("");
		frequencyText.setBorder(BorderFactory.createLineBorder(Color.black));
		frequencyText.setBackground(ServerConstants.PINK);
		frequencyText.setPreferredSize(ServerConstants.TEXT_DIMENSION);
		frequencyText.setEditable(true);
		this.add(frequencyValuePanel);
		frequencyValuePanel.add(frequencyLabel);
		this.add(frequencyText);

	}

}
