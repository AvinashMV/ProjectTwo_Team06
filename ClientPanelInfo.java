//package clientServer.ProjectTwo_Team06;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ClientPanelInfo extends JPanel {
    
    public ClientPanelInfo() {
        createLayout();
        createAndShowGUI();
    }
    
    private void createLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    private void createAndShowGUI() {
        ClientPanelHighest highest = new ClientPanelHighest();
        ClientPanelLowest lowest = new ClientPanelLowest();
        ClientPanelAverage average = new ClientPanelAverage();
        ClientPanelChannels channels = new ClientPanelChannels();
        ClientPanelFrequency frequency = new ClientPanelFrequency();           
        add(highest);
        add(lowest);
        add(average);
        add(channels);
        add(frequency);
    }
}
