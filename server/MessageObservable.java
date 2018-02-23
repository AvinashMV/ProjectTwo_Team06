package server;

import java.util.Observable;

/**
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
