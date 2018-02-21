import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Rishab Mantri (#69)
 */
public class ServerPanelData extends JPanel {
	ServerStatusPanel serverStatusPanel;
	ServerControlPanel serverControlPanel;
	JSplitPane sPane;
    
    public ServerPanelData() {
    		createLayout();
        createAndShowGUI();
    }
    
    private void createLayout() {
    		setLayout(new GridLayout());
	}



	private void createAndShowGUI() {
		setPreferredSize(new Dimension(400, 400));
        setBackground(StandardColor.PINK);
        serverStatusPanel= new ServerStatusPanel();
        serverControlPanel = new ServerControlPanel();
        JSplitPane splitPane = new JSplitPane();
    	Border line = BorderFactory.createLineBorder(StandardColor.LIGHT_BLUE,5);
    	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
    	setBorder( BorderFactory.createCompoundBorder(
                line, loweredbevel));
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  
        splitPane.setDividerLocation(400);                   
        splitPane.setLeftComponent(serverStatusPanel);
        splitPane.setRightComponent(serverControlPanel);
        add(splitPane);
        
		
    }
}
