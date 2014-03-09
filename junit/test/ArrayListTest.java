import java.util.ArrayList;
import java.util.List;

public class ArrayListTest extends junit.framework.TestCase {

    private List list;

    protected void setUp() {
	list = new ArrayList();
    }
    
    public void testAddElement() {
	assertFalse(list.contains("junit"));
	list.add("junit");
	assertTrue(list.contains("junit"));
    }

    public void testRemoveElement() {
	list.add("junit");
	assertTrue(list.contains("junit"));
	list.remove("junit");
	assertFalse(list.contains("junit"));
    }
}
