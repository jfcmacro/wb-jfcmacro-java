public class CIAObserver implements Observer {

    private BookRegister bookRegister;

    public CIAObserver(BookRegister bookRegister) {
        this.bookRegister = bookRegister;
        bookRegister.register(this);
    }

    public void update(int id) {
        if (id == 0) {
            System.out.printf("There is a possible terrorist borrowing books%n");
        }
    }
}
