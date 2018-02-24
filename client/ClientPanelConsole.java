package client;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import server.StandardColor;

/**
 * ClientPanelConsole class initializes and set ups attributes for panel
 * 
 * @author Team 6
 *
 */
public class ClientPanelConsole extends JPanel {

	public ClientPanelConsole() {
		Border line = BorderFactory.createLineBorder(StandardColor.LIGHT_BLUE, 5);
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		setBorder(BorderFactory.createCompoundBorder(line, loweredbevel));
		JLabel test = new JLabel(ClientConstants.CONSOLE);
		test.setPreferredSize(new Dimension(600, 150));
		setBackground(StandardColor.SLATE_GREY);
		add(test);
	}
}