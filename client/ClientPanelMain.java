package client;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * ClientPanelMain class initializes the main GUI component
 * 
 * @author Team 06
 */
public class ClientPanelMain extends JPanel {
	private ClientPanelTop panelTop;
	private ClientPanelData panelData;
	private ClientPanelConsole panelConsole;

	public ClientPanelMain() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		panelData = new ClientPanelData();
		ClientDataManager.getInstance().setPanelData(panelData);
		panelConsole = new ClientPanelConsole();
		ClientDataManager.getInstance().setPanelConsole(panelConsole);
		panelTop = new ClientPanelTop();
		add(panelTop);
		add(panelData);
		add(panelConsole);
	}
}