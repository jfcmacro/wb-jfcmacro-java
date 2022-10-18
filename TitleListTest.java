import java.util.Iterator;

public class TitleListTest {
    public static void main(String[] args) {
        TitleList tl = new TitleList();

        tl.addTitle("Begin Java 8");
        tl.addTitle("Scripting in Java");

        Iterator iterator = tl.titleIterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
