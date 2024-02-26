public class LibraryObserver implements Observer {

    private BookRegister bookRegister;

    public LibraryObserver(BookRegister bookRegister) {
        this.bookRegister = bookRegister;
        bookRegister.register(this);
    }

    public void update(int id) {
        System.out.printf("A book has been borrowed %d%n", id);
    }
}
