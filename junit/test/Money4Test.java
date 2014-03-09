import org.junit.*;
import static org.junit.Assert.*;

public class Money4Test {

    @Test 
    public void simpleAdd() {
	Money m12CHF = new Money(12, "CHF");
	Money m14CHF = new Money(14, "CHF");
	Money expected = new Money(26, "CHF");
	Money result = m12CHF.add(m14CHF);
	assertTrue(expected.equals(result));
    }

    @Test 
    public void simpleAddFail() {
	Money m12CHF = new Money(12, "CHF");
	Money m14CHF = new Money(14, "CHF");
	Money expected = new Money(24, "CHF");
	Money result = m12CHF.add(m14CHF);
	assertTrue(expected.equals(result));
    }

}