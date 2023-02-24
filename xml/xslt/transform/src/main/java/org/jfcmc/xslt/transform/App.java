package org.jfcmc.xslt.transform;

import net.sf.saxon.Transform;
public class App {
    public static void main(String[] args) {
	String[] args2 = { "-xls:articulo-2-html.xls", "-s:articulo.xsml", "-o:articulo.html" };
	Transform transform = new Transform();
        transform.doTransform(args2);
    }
}
