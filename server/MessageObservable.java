package server;
import java.util.Observable;

/**
 * Lab 2, Team 6
 * 
 * @author SER 516, Garv Mathur (#72)
 */

class MessageObservable extends Observable {
	MessageObservable() {
		super();
	}

	void changeData(Object data) {
		setChanged(); // the two methods of Observable class
		notifyObservers(data);
	}
}
