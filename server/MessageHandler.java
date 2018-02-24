package server;

/**
 * The MessageHandler class
 * 
 * @author Team 06
 * @version 1.0
 */
public class MessageHandler {

	private static volatile MessageHandler messageHandler;
	private static Object mutex = new Object();
	private ServerStatusPanel serverStatusPanel;
	private ServerTopPanel serverTopPanel;
	private ServerConsolePanel serverConsolePanel;

	public ServerConsolePanel getServerPanelConsole() {
		return serverConsolePanel;
	}

	public void setServerPanelConsole(ServerConsolePanel serverPanelConsole) {
		this.serverConsolePanel = serverPanelConsole;
	}

	public ServerStatusPanel getServerStatusPanel() {
		return serverStatusPanel;
	}

	public void setServerStatusPanel(ServerStatusPanel serverStatusPanel) {
		this.serverStatusPanel = serverStatusPanel;
	}

	public ServerTopPanel getServerPanelTop() {
		return serverTopPanel;
	}

	public void setServerPanelTop(ServerTopPanel serverPanelTop) {
		this.serverTopPanel = serverPanelTop;
	}

	private MessageHandler() {
	}

	/*
	 * 
	 */
	public static MessageHandler getInstance() {
		MessageHandler result = messageHandler;
		if (result == null) {
			synchronized (mutex) {
				result = messageHandler;
				if (result == null)
					result = new MessageHandler();
				messageHandler = result;
			}
		}
		return result;
	}
}
