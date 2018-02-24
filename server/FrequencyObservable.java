package server;

import java.util.Observable;

/**
 * The FrequencyObservable class
 * 
 * @author Team 06
 * @version 1.0
 */
class FrequencyObservable extends Observable {
	FrequencyObservable() {
		super();
	}

	void changeData(Object data) {
		setChanged();
		notifyObservers(data);
	}
}
