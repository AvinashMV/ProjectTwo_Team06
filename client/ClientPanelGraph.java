package client;

//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * 
 * @author SER 516, Gary Morris (#78)
 */
public class ClientPanelGraph extends JPanel {

	public ClientPanelGraph() {
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		JLabel test = new JLabel("GRAPH");
		test.setPreferredSize(new Dimension(400, 400));
		setBackground(Color.white);
		add(test);
	}
}
