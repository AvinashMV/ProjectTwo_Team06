//package clientServer.ProjectTwo_Team06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class ServerPanelLowest extends JPanel{
    
    JPanel lowestValuePanel;
    JLabel lowLabel;
    JFormattedTextField lowTxt;
    int lowestValue;

	 public ServerPanelLowest() {
	        createAndShowGUI();
	    }
	    
	    private void createAndShowGUI() {
	        lowestValuePanel = new JPanel();
	        lowLabel = new JLabel("<html>Lowest<br>Value:</html>");
	        
	        lowLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
	        lowLabel.setSize(85, 60);
	        lowestValuePanel.setPreferredSize(new Dimension(120, 60));
	        lowestValuePanel.setBackground(StandardColor.PINK);
	        lowestValuePanel.setBorder(BorderFactory.createLineBorder(Color.black));
	        
	        //added text panel where the highest value will go.
	        lowTxt = new JFormattedTextField(ServerHelper.formatter());
            lowTxt.setText("0");
	        lowTxt.setBorder(BorderFactory.createLineBorder(Color.black));
	        lowTxt.setBackground(StandardColor.LIGHT_BLUE);
	        lowTxt.setPreferredSize(new Dimension(120, 60));
	        lowTxt.setEditable(true);
                
	        add(lowestValuePanel);
	        lowestValuePanel.add(lowLabel);
	        add(lowTxt);
	    }
            
            public int getLowestValue()
            {
                
                lowestValue= Integer.parseInt(lowTxt.getText());
                return lowestValue;
            }


}
