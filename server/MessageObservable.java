package server;

import java.util.Observable;

/**
 * The MessageObservable class
 * 
 * @author Team 06
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
