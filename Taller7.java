public class Taller7 {

    public static void main(String []args) {
	Taller7 taller7 = new Taller7();
	taller7.conCat("","");
    } 

    public String conCat(String a, String b) {
	String strp; 
	if (a.length() == 0 || b.length() == 0) {
	    strp = a + b;
	}
	else if (a.length() == 0) {
	    strp = b;
	}
	else if (b.length() == 0) {
	    strp = a;
	} 
	else if (a.charAt(a.length() -1) == b.charAt(0)) {
	    strp = a + b.substring(1);
	}
	return strp;
    }
}