
public class BigLittleImpl implements BigLittle {

    public int bigToLittleInt(int value) {

	int result = 0;
	
	int i = 0;

	for (i = 0; i < 4; i++) {
	    
	    result = (result << 8) | (value & 0x0FF);
	    value = value >> 8;
	}

	return result;
    }

    public long bigToLittleLong(long value) {

	long result = 0;
	
	int i = 0;

	for (i = 0; i < 8; i++) {
	    
	    result = (result << 8) | (value & 0x0FF);
	    value = value >> 8;

	    System.out.println("res: " + result + " value: " + value);
	}

	System.out.println("Result: " + result);

	return result;
    }
}
