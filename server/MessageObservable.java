package server;

import java.util.Observable;

/**
 * The MessageHandler class
 * 
 * @author
 * @version 1.0
 */
class MessageObservable extends Observable {
	MessageObservable() {
		super();
	}

	void changeData(Object data) {
		setChanged();
		notifyObservers(data);
	}
}
