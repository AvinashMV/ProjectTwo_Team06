import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * For lab2, 516
 * @author avinash mathad vijayakumar
 *
 */

public class ServerDisplayConsole extends JPanel{
	public ServerDisplayConsole() {
		JLabel label=new JLabel("Console");
		add(label);
	}
	
	public static void main(String[] args) {
		JPanel console=new ServerDisplayConsole();
		JFrame f=new JFrame("Simple Window");
		f.setSize(800,800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(console);
		f.pack();
		//f.add(p);
		f.setVisible(true);
	}
}
