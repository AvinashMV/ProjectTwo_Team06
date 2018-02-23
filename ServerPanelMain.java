//package clientServer.ProjectTwo_Team06;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Rishab Mantri (#69)
 */
public class ServerPanelMain extends JPanel {
    ServerPanelTop panelTop;
    ServerPanelData panelData;
    ServerPanelConsole panelConsole;
    
    public ServerPanelMain() {
        createLayout();
        createAndShowGUI();
    }
    
    private void createLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    private void createAndShowGUI() {
    		panelConsole = new ServerPanelConsole();
    		MessageHandler.getInstance().setServerPanelConsole(panelConsole);
    		
    	 	panelData = new ServerPanelData();
        panelTop = new ServerPanelTop();
        
        add(panelTop);
        add(panelData);
        add(panelConsole);
    }
}
