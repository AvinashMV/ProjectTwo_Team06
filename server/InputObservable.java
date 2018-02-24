package server;

import java.util.Observable;

class InputObservable extends Observable {
	InputObservable() {
		super();
	}

	void changeData(Object data) {
		setChanged(); // the two methods of Observable class
		notifyObservers(data);
	}
}
