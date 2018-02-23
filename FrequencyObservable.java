import java.util.Observable;

class FrequencyObservable extends Observable {
	FrequencyObservable() {	
        super();
    }
    void changeData(Object data) {
        setChanged(); // the two methods of Observable class
        notifyObservers(data);
    }
} 
