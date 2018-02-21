//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Rishab Mantri (#69)
 */
public class ServerPanelTop extends JPanel {
	JButton serverControlButton;
	
    public ServerPanelTop() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
        JLabel test = new JLabel("TOP");
        serverControlButton =  new JButton();
        test.setPreferredSize(new Dimension(600, 50));
        setBackground(StandardColor.LIGHT_BLUE);
        serverControlButton.setText("Start/Stop");
        serverControlButton.setBackground(Color.PINK);
        add(test);
        add(serverControlButton);
    }
}
