import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Aman Maheshwari (#66)
 * @author SER 516, Rishabh Modi (#75)
 */
public class ClientPanelTop extends JPanel {
    
    public ClientPanelTop() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
        ClientStartStop clientstartstop = new ClientStartStop();
        JPanel test = new JPanel();
        test.setPreferredSize(new Dimension(560, 50));        
    	JButton startStop = new JButton("Start / Stop");
        startStop.setBackground(Color.pink);
        startStop.setBorder(BorderFactory.createLineBorder(Color.black));
        startStop.setPreferredSize(new Dimension(100, 50));
        startStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clientstartstop.flag==true)
                {
                    clientstartstop.start();
                    clientstartstop.flag = false;
                }
                else
                {
                    clientstartstop.stop();
                    clientstartstop.flag = true;
                }

            }
        });
        add(test);
        add(startStop);
    }
}
