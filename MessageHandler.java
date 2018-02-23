
public class MessageHandler {
	
	private static volatile MessageHandler messageHandler;
	private static Object mutex = new Object();
	private ServerStatusPanel serverStatusPanel;
	private ServerPanelTop serverPanelTop;
	private ServerPanelConsole serverPanelConsole;

	
	public ServerPanelConsole getServerPanelConsole() {
		return serverPanelConsole;
	}

	public void setServerPanelConsole(ServerPanelConsole serverPanelConsole) {
		this.serverPanelConsole = serverPanelConsole;
	}

	public ServerStatusPanel getServerStatusPanel() {
		return serverStatusPanel;
	}

	public void setServerStatusPanel(ServerStatusPanel serverStatusPanel) {
		this.serverStatusPanel = serverStatusPanel;
	}

	public ServerPanelTop getServerPanelTop() {
		return serverPanelTop;
	}

	public void setServerPanelTop(ServerPanelTop serverPanelTop) {
		this.serverPanelTop = serverPanelTop;
	}

	private MessageHandler() {
	}

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
