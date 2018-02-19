import java.io.IOException;
import java.net.Socket;

/**
 * 
 * @author Salil
 *
 */
public class ServerStartStop {
	Socket serverSocket = null;

	void start() {
		try {
			serverSocket = new Socket("localhost", 1516);
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void stop() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
