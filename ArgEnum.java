public class ArgEnum {

    private enum Test { Cero, Uno, Dos, Tres };
    
    public static int f(Enum x) {
	return x.ordinal();
    }

    private Enum currentValue = null;

    public ArgEnum(Enum currentValue) {
	this.currentValue = currentValue;
    }

    public boolean equals(Object o) {
	boolean retValue = false;

	if (o instanceof ArgEnum && currentValue.ordinal() == o.hashCode())
		retValue = true;

	return retValue;
    }

    public int hashCode() {
	return currentValue.ordinal();
    }
    
    public static void main(String args[]) {
	
	ArgEnum uno = new ArgEnum(Test.Uno);
	ArgEnum dos = new ArgEnum(Test.Dos);
	ArgEnum otroUno = new ArgEnum(Test.Uno);
	Integer otroUnoMas = 1;

	System.out.println("uno is equals to dos: " + uno.equals(dos));
	System.out.println("uno is equals to otroUno: " + uno.equals(otroUno));
	System.out.println("uno is equals to otroUnoMas: " + uno.equals(otroUnoMas));
       
    }
				     
}
