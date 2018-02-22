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
 * This class implements a console panel to display any status , erros related to server.
 * For lab2, 516
 * @author avinash mathad vijayakumar(#71).
 *
 */
public class ServerDisplayConsole{
	
	private JPanel panel_console;
	private JLabel label_console;
	private JLabel label_msg;
	
	/**
	 * Constructor which creates a JPanel for console window. 
	 */
	public ServerDisplayConsole() {
		ConstructPanel();
	}
	
	/**
	 * This method constructs JPanel and adds Jlabel for text display.
	 * @return JPanel called panel_console.
	 */
	private JPanel ConstructPanel() {
		panel_console= new JPanel();
		label_console=new JLabel("Console");	
		panel_console.setLayout(new BorderLayout());
		panel_console.add(label_console,BorderLayout.NORTH);
		label_msg=new JLabel("Console display msg testing.");
		panel_console.add(label_msg);
		return panel_console;
	}
	
	/**
	 * @param data: String type to display message in console.
	 */
	public void SetServer_ConsoleData(String data) {
		label_msg.setText(data);
	}
	
	/**
	 * This is for testing and demo usage purpose.
	 * JPanel is added to JFrame and displayed.
	 * 
	 * @param args: Not used.
	 */
	public static void main(String[] args) {
		ServerDisplayConsole ref_ob=new ServerDisplayConsole();
		JPanel panel_to_add= ref_ob.ConstructPanel(); 
		String msg="Server Status message goes here.";
		ref_ob.SetServer_ConsoleData(msg);
		JFrame f=new JFrame("Simple Console Window");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(panel_to_add);
		f.pack();
		f.setVisible(true);
	}
}
