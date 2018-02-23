
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ServerControlPanel extends JPanel {

	public ServerControlPanel() {
		createLayout();
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		setBackground(StandardColor.SLATE_GREY);
		ServerPanelHighest highest = new ServerPanelHighest();
		ServerPanelLowest lowest = new ServerPanelLowest();
		ServerPanelFrequency frequency = new ServerPanelFrequency();
		add(highest);
		add(lowest);
		add(frequency);

		// TODO Auto-generated method stub

	}

	private void createLayout() {
		// TODO Auto-generated method stub
		// setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}
}
