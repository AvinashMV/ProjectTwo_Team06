import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.layout.Border;


/**
 * For lab2, 516
 * @author avinash mathad vijayakumar
 *
 */

public class ServerDisplayConsole{
	
	private JPanel panel_console;
	private JLabel label_console;
	private JLabel label_msg;
	
	public ServerDisplayConsole() {
		ConstructPanel();
	}
	
	public JPanel ConstructPanel() {
		panel_console= new JPanel();
		label_console=new JLabel("Console");	
		panel_console.setLayout(new BorderLayout());
		panel_console.add(label_console,BorderLayout.NORTH);
		
		label_msg=new JLabel("This is just text to display..");
		panel_console.add(label_msg);
		return panel_console;
	}
	
	
	public void SetServer_ConsoleData(String data) {
		label_msg.setText(data);
	}
	
	public static void main(String[] args) {
		ServerDisplayConsole ob=new ServerDisplayConsole();
		ServerDisplayConsole ref_ob=new ServerDisplayConsole();
		JPanel panel_to_add= ref_ob.ConstructPanel();
		// to test the display in the console. 
		String msg="ASU is No1 in US for innovation";
		ref_ob.SetServer_ConsoleData(msg);
		JFrame f=new JFrame("Simple Window");
		f.setSize(1900,1900);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(panel_to_add);
		f.pack();
		f.setVisible(true);
	}
}
