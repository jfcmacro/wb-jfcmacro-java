public class IdEnum {
    enum Primera { PCero, PUno };
    enum Segunda { SCero, SUno };

    public static void testEnum(Enum value) {
	if (value instanceof Primera) {
	    System.out.println("Primera");
	}
	if (value instanceof Segunda) {
	    System.out.println("Segunda");
	}
    }

    public static void testEnum2(Enum value, Enum value2) {
	if (value.getClass().equals(value2.getClass())) {
	    System.out.println("Las mismas clases");
	}
	else {
	    System.out.println("Diferentes clases");
	}
    }

    public static void main(String args[]) {

	Primera val = Primera.PCero;
	Segunda val2 = Segunda.SCero;

	testEnum(val);
	testEnum(val2);
	testEnum2(Primera.PCero, Primera.PUno);
	testEnum2(Primera.PCero, Segunda.SUno);
    }
					  
}
