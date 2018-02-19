import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ClientPanelData extends JPanel {
    
    public ClientPanelData() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
        ClientPanelGraph graph = new ClientPanelGraph();
        ClientPanelInfo info = new ClientPanelInfo();
        add(graph);
        add(info);
    }
}
