//package clientServer.ProjectTwo_Team06;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ClientPanelMain extends JPanel {
    ClientPanelTop panelTop;
    ClientPanelData panelData;
    ClientPanelConsole panelConsole;
    
    public ClientPanelMain() {
        createLayout();
        createAndShowGUI();
    }
    
    private void createLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    private void createAndShowGUI() {
        panelTop = new ClientPanelTop();
        panelData = new ClientPanelData();
        panelConsole = new ClientPanelConsole();
        add(panelTop);
        add(panelData);
        add(panelConsole);
    }
}
