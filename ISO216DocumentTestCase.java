import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ISO216DocumentTestCase {
    @Test public void testA4Width() {
        ISO216Document doc = new ISO216Document("A4");
        assertEquals(210, doc.getWidth());
    }

    @Test public void testA4Height() {
        ISO216Document doc = new ISO216Document("a4");
        assertEquals(297, doc.getHeight());
    }

    @Test public void testA3Width() {
        ISO216Document doc = new ISO216Document("a3");
        assertEquals(297, doc.getWidth());
    }

    @Test public void testA3Height() {
        ISO216Document doc = new ISO216Document("A3");
        assertEquals(420, doc.getHeight());
    }

    @Test public void testDefaultWidth() {
        ISO216Document doc = new ISO216Document("");
        assertEquals(210, doc.getWidth());
    }

    @Test public void testDefaultHeight() {
        ISO216Document doc = new ISO216Document("Whatever");
        assertEquals(297, doc.getHeight());
    }


}
