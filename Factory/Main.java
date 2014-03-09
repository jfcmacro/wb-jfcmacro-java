
public class Main {


    public static void main(String args[]) {


	IParser parser = FactoryParser.crearParser(1);

	parser.doParser();

	parser = FactoryParser.crearParser(2);

	parser.doParser();

    }

}
