//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class ServerPanelFrequency extends JPanel{
	 public ServerPanelFrequency() {
	        createAndShowGUI();
	    }
	    
	    private void createAndShowGUI() {
	        JPanel test = new JPanel();
	        JLabel highLabel = new JLabel("<html>Frequency<br>(Hz)</html>");
	        
	        highLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
	        highLabel.setSize(85, 60);
	        test.setPreferredSize(new Dimension(120, 60));
	        test.setBackground(StandardColor.LIGHT_BLUE);
	        test.setBorder(BorderFactory.createLineBorder(Color.black));
	        
	        //added text panel where the highest value will go.
	        JTextPane highTxt = new JTextPane();
	        highTxt.setBorder(BorderFactory.createLineBorder(Color.black));
	        highTxt.setBackground(StandardColor.PINK);
	        highTxt.setPreferredSize(new Dimension(120, 60));
	        highTxt.setEditable(false);
	        
	        add(test);
	        test.add(highLabel);
	        add(highTxt);
	    }

}
