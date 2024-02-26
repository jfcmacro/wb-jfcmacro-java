public class ObserverMain {

    public static void main(String...args) {
        BookRegister bookRegister = new BookRegister();
        Observer first = new LibraryObserver(bookRegister);
        Observer second = new CIAObserver(bookRegister);

        bookRegister.notifyObservers(1);
        bookRegister.notifyObservers(2);
        bookRegister.notifyObservers(3);
        bookRegister.notifyObservers(0);

        Observer third = new LibraryObserver(bookRegister);

        bookRegister.notifyObservers(1);
        bookRegister.notifyObservers(2);
        bookRegister.notifyObservers(3);
        bookRegister.notifyObservers(0);

        
    }
}
