//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ServerPanelFrequency extends JPanel implements ActionListener{
    
    JPanel frequencyPanel;
    JLabel frequencyLabel;
    JFormattedTextField frequencyTxt;
    int frequency;
    FrequencyObservable observable;
	 public ServerPanelFrequency() {
	        createAndShowGUI();
	    }
	    
	    private void createAndShowGUI() {
	        frequencyPanel = new JPanel();
	        frequencyLabel = new JLabel("<html>Frequency<br>(Hz)</html>");
	        frequencyLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
	        frequencyLabel.setSize(85, 60);
	        frequencyPanel.setPreferredSize(new Dimension(120, 60));
	        frequencyPanel.setBackground(StandardColor.LIGHT_BLUE);
	        frequencyPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	        
	        //added text panel where the frequency value will go.
	        frequencyTxt = new JFormattedTextField(ServerHelper.formatter());
            frequencyTxt.setText("4");
	        frequencyTxt.setBorder(BorderFactory.createLineBorder(Color.black));
	        frequencyTxt.setBackground(StandardColor.PINK);
	        frequencyTxt.setPreferredSize(new Dimension(120, 60));
	        frequencyTxt.setEditable(true);
	        frequencyTxt.addActionListener(this);
	        observable = new FrequencyObservable();
	        observable.addObserver(MessageHandler.getInstance().getServerSocketMain());
	        add(frequencyPanel);
	        frequencyPanel.add(frequencyLabel);
	        add(frequencyTxt);
	    }
            
               

		@Override
		public void actionPerformed(ActionEvent e) {
			JFormattedTextField frequency = (JFormattedTextField) e.getSource();
			observable.changeData(frequency.getValue());
		}

}
