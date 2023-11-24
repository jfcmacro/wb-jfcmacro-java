# Transformation

This project show how to use XSLT Tranformation, but I was intended to be used directly with command line

```shell
$ java -jar $SAXON_HOME/Saxon-HE-11.4.jar -xsl:articulo-2-html.xsl -s:articulo.xml -o:articulo.html
```

But it wasn't possible because `Saxon-HE-11.4.jar` package has a lot of dependencies, particually to xmlresolver.
I downloaded and trie to use directly on the project, but I got the same error.

```shell
$ java -cp $XMLRESOLVER_HOME/xmlresolver-4.4.3.jar -jar $SAXON_HOME/Saxon-HE-11.4.jar -xsl:articulo-2-html.xsl -s:articulo.xml -o:articulo.html
$ java -cp $SAXON_HOME/Saxon-HE-11.4.jar:$XMLRESOLVER_HOME/xmlresolver-4.4.3.jar net.sf.saxon.Transform -xsl:articulo-2-html.xsl -s:articulo.xml -o:articulo.html
```

But, in both cases it failed.

Then, I decided to implement this project where maven manage directly the construction of the $CLASSPATH, and it works

To execute:
```shell
mvn compile exec:java -Dexec.mainClass="org.jfcmc.xslt.transform.App" -Dexec.args="-xsl:articulo-2-html.xsl -s:articulo.xml -o:articulo.html"
```