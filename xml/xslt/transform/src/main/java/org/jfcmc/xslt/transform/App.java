package org.jfcmc.xslt.transform;

import net.sf.saxon.Transform;
public class App {
    public static void main( String[] args ) {
    	String[] args2 = { "-xsl:articulo-2-html.xsl", "-s:articulo.xml", "-o:articulo.html" };
	Transform transform = new Transform();
        transform.doTransform(args2);
    }
}
