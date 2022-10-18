public class DefaultTest {

    public static void main(String []args) {
        int val = 10;

        switch (val) {
        case 0:
        case 1:
            System.out.println("This pass");
            break;
        default:
            System.out.println("I was wrong");
            break;
        case 2:
            System.out.println("This pass too");
            break;
        }
    }
}
