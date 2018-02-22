//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class ServerPanelHighest extends JPanel{
	
    JPanel highestValuePanel;
    JLabel highLabel;
    JTextPane highTxt;
    int highestValue;
    
	 public ServerPanelHighest() {
	        createAndShowGUI();
	    }
	    
	    private void createAndShowGUI() {
	        highestValuePanel = new JPanel();
	        highLabel = new JLabel("<html>Highest<br>Value</html>");
	        
	        highLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
	        highLabel.setSize(85, 60);
	        highestValuePanel.setPreferredSize(new Dimension(120, 60));
	        highestValuePanel.setBackground(StandardColor.LIGHT_BLUE);
	        highestValuePanel.setBorder(BorderFactory.createLineBorder(Color.black));
	        
	        //added text panel where the highest value will go.
	        highTxt = new JTextPane();
                highTxt.setText("1024");
	        highTxt.setBorder(BorderFactory.createLineBorder(Color.black));
	        highTxt.setBackground(StandardColor.PINK);
	        highTxt.setPreferredSize(new Dimension(120, 60));
	        highTxt.setEditable(true);
	        
	        add(highestValuePanel);
	        highestValuePanel.add(highLabel);
	        add(highTxt);
	    }
            
                public int getHighestValue()
                {
                    highestValue= Integer.parseInt(highTxt.getText());
                    return highestValue;
                }

}
