import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ClientPanelData extends JPanel {
    
	public Color LIGHTPINK = new Color(255,182,193);
	
    public ClientPanelData() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
    	ClientPanelInfo info = new ClientPanelInfo();
    	ClientPanelGraph graph = new ClientPanelGraph();
    	//add(createAndShowGraph());
		add(graph);
        add(info);
    }
       
 }

