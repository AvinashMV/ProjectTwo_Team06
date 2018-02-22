//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class ServerPanelFrequency extends JPanel{
    
    JPanel frequencyPanel;
    JLabel frequencyLabel;
    JTextPane frequencyTxt;
    int frequency;
	 public ServerPanelFrequency() {
	        createAndShowGUI();
	    }
	    
	    private void createAndShowGUI() {
	        frequencyPanel = new JPanel();
	        frequencyLabel = new JLabel("<html>Frequency<br>(Hz)</html>");
	        frequencyLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
	        frequencyLabel.setSize(85, 60);
	        frequencyPanel.setPreferredSize(new Dimension(120, 60));
	        frequencyPanel.setBackground(StandardColor.LIGHT_BLUE);
	        frequencyPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	        
	        //added text panel where the frequency value will go.
	        frequencyTxt = new JTextPane();
                frequencyTxt.setText("4");
	        frequencyTxt.setBorder(BorderFactory.createLineBorder(Color.black));
	        frequencyTxt.setBackground(StandardColor.PINK);
	        frequencyTxt.setPreferredSize(new Dimension(120, 60));
	        frequencyTxt.setEditable(false);
	        
	        add(frequencyPanel);
	        frequencyPanel.add(frequencyLabel);
	        add(frequencyTxt);
	    }
            
                public int getFrequency()
                {
                    frequency= Integer.parseInt(frequencyTxt.getText());
                    return frequency;
                }

}
