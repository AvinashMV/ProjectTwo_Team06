//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Rishab Mantri (#69)
 */
public class ServerPanelConsole extends JPanel {
    
    public ServerPanelConsole() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
    	Border line = BorderFactory.createLineBorder(StandardColor.LIGHT_BLUE,5);
    	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
    	setBorder( BorderFactory.createCompoundBorder(
                line, loweredbevel));
        JLabel test = new JLabel("CONSOLE");
        test.setPreferredSize(new Dimension(600, 150));
        setBackground(StandardColor.SLATE_GREY);
        
        add(test);
    }
}
