import java.util.List;
import java.util.ArrayList;

public class BookRegister implements Observable {
    private List<Observer> observers;

    public BookRegister() {
        observers = new ArrayList<>();
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public void unregister(Observer o) {
        int index = observers.indexOf(o);

        if (index >= 0) {
            observers.remove(index);
        }
    }

    public void notifyObservers(int id) {
        observers.stream().forEach(o -> o.update(id));
    }
}
