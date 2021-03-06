package client;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import server.ServerConstants;


/**
 * ClientPanelData class initializes and sets the graph and info panel
 * 
 * @author Team 6
 *
 */
public class ClientPanelData extends JPanel {

	public ClientPanelData() {
		Border line = BorderFactory.createLineBorder(ClientConstants.LIGHT_BLUE, 5);
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		setBorder(BorderFactory.createCompoundBorder(line, loweredbevel));
		setBackground(ServerConstants.SLATE_GREY);
		ClientPanelGraph graph = new ClientPanelGraph();
		ClientPanelInfo info = new ClientPanelInfo();
		ClientDataManager.getInstance().setInfo(info);
		add(graph);
		add(info);
	}

}
