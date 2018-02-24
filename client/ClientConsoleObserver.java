package client;

import java.util.Observable;

class ClientConsoleObserver extends Observable {
	ClientConsoleObserver() {
		super();
	}

	void changeData(Object data) {
		setChanged(); // the two methods of Observable class
		notifyObservers(data);
	}
}
