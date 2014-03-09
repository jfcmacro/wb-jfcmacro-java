import java.math.BigInteger;

public class EnteroGrande {

	public static void main(String []args) {

		BigInteger bg1 = new BigInteger("10567991238934");
		BigInteger bg2 = new BigInteger("20223334332222");
		BigInteger bg3 = new BigInteger("3432323222322");
		BigInteger bg4 = new BigInteger("22224343211222");

		System.out.println(""+bg1 + " + " + bg2);
		System.out.println("" + bg1.add(bg2));
		System.out.println(""+bg3 + " - " + bg4);
		System.out.println("" + bg3.subtract(bg4));
		System.out.println(""+bg3 + " < " + bg1);
		System.out.println(""+ (bg3.compareTo(bg1) == -1 ? true : false));
		System.out.println(""+bg2 + " > " + bg4);
		System.out.println(""+ (bg2.compareTo(bg4) == 1 ? true : false));

	}

}
