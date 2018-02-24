package client;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ClientPanelGraph class creates the JPanel object for graph and specifies the
 * attributes for graph panel
 * 
 * @author Team 6
 *
 */
public class ClientPanelGraph extends JPanel {

	public ClientPanelGraph() {
		JLabel test = new JLabel("GRAPH");
		test.setPreferredSize(new Dimension(400, 400));
		setBackground(Color.white);
		add(test);
	}

}
