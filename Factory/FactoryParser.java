
public class FactoryParser {


    public static IParser crearParser(int i) {

	if (i % 2 == 0)
	    return (IParser) new ParserDFX();
	else
	    return (IParser) new ParserOtros();
    }

}
