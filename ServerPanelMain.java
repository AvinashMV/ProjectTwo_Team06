import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
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
        panelTop = new ServerPanelTop();
        panelData = new ServerPanelData();
        panelConsole = new ServerPanelConsole();
        add(panelTop);
        add(panelData);
        add(panelConsole);
    }
}
