//package clientServer.ProjectTwo_Team06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class ServerPanelLowest extends JPanel{

	 public ServerPanelLowest() {
	        createAndShowGUI();
	    }
	    
	    private void createAndShowGUI() {
	        JPanel test = new JPanel();
	        JLabel lowLabel = new JLabel("<html>Lowest<br>Value:</html>");
	        
	        lowLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
	        lowLabel.setSize(85, 60);
	        test.setPreferredSize(new Dimension(120, 60));
	        test.setBackground(StandardColor.PINK);
	        test.setBorder(BorderFactory.createLineBorder(Color.black));
	        
	        //added text panel where the highest value will go.
	        JTextPane lowTxt = new JTextPane();
	        lowTxt.setBorder(BorderFactory.createLineBorder(Color.black));
	        lowTxt.setBackground(StandardColor.LIGHT_BLUE);
	        lowTxt.setPreferredSize(new Dimension(120, 60));
	        lowTxt.setEditable(false);
	        
	        add(test);
	        test.add(lowLabel);
	        add(lowTxt);
	    }


}
