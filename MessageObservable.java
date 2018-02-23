import java.util.Observable;

class MessageObservable extends Observable {
    MessageObservable() {	
        super();
    }
    void changeData(Object data) {
        setChanged(); // the two methods of Observable class
        notifyObservers(data);
    }
} 
