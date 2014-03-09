import org.xml.sax.ContentHandler;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;
import java.util.Set;
import java.util.HashSet;


class ExprSAXHandler implements 
			 ContentHandler, 
			 ErrorHandler {

    private boolean collectIds = false;
    private Set<String> collectedIds = new HashSet<String>();


    // 
    public Set<String> getCollectedIds() {
	return collectedIds;
    }

    // ContentHandle interface

    public void characters(char[] ch, int start, int length) {
	if (collectIds) {
	    collectedIds.add((new String(ch)).trim());
	}
    }

    public void endDocument() {
    }

    public void endElement(String uri, String localName, String qName) {
	if (localName.equals("ID")) {
	    collectIds = false;
	}
    }

    public void endPrefixMapping(String prefix) {
    }

    public void ignorableWhitespace(char[] ch, int start, int length) {
    }

    public void processingInstruction(String target, String data) {
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String name) {
    }

    public void startDocument() {
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) {

	if (localName.equals("ID")) {
	    collectIds = true;
	}
    }

    public void startPrefixMapping(String prefix, String uri) {
    }

    // ErrorHandler
    public void error(SAXParseException e) 
	throws SAXParseException {

	System.err.println("Error while it was processing at line: " 
			   + e.getLineNumber() + " and column: " + e.getColumnNumber());
	throw e;
    }

    public void fatalError(SAXParseException e) 
	throws SAXParseException {

	System.err.println("fatal error while it was processing at line: " 
			   + e.getLineNumber() + " and column: " + e.getColumnNumber());
	throw e;
    }

    public void warning(SAXParseException e) 
	throws SAXParseException {

	System.err.println("fatal error while it was processing at line: " 
			   + e.getLineNumber() + " and column: " + e.getColumnNumber());
	throw e;
    }
}