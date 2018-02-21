import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Aman Maheshwari (#66)
 */
public class ClientPanelData extends JPanel {
    
	public Color LIGHTPINK = new Color(255,182,193);
	
    public ClientPanelData() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {

    	ClientPanelInfo info = new ClientPanelInfo();
    	ClientPanelGraph graph = new ClientPanelGraph();
    	/*
    	Border line = BorderFactory.createLineBorder(StandardColor.LIGHT_BLUE,5);
    	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
    	setBorder(BorderFactory.createCompoundBorder(line, loweredbevel));
    	setBackground(StandardColor.SLATE_GREY);*/
        add(graph);
        add(info);
    }
       
 }

