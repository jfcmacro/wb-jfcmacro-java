package org.jfcmc.test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import org.jfcmc.annotation.Version;

public class AccessAnnotationTest {
    public static void main(String[] args) {

        Class<AccessAnnotation> c = AccessAnnotation.class;
        System.out.println("Annotations for class:" + c.getName());
        printAnnotations(c);

        Package p = c.getPackage();
        System.out.println("Annotations for package:" + p.getName());
        printAnnotations(p);

        System.out.println("Method annotations:");
        Method[] ms = c.getDeclaredMethods();
        for (Method m: ms) {
            System.out.println("Annotations for method:" + m.getName());
            printAnnotations(m);
        }
    }

    public static void printAnnotations(AnnotatedElement programElement) {
        Annotation[] annList = programElement.getAnnotations();
        // for (int i = 0; i < annList.length; i++) {
        for (Annotation ann : annList) {
            System.out.println(ann);
            if (ann instanceof Version) {
                Version v = (Version) ann;
                int major = v.major();
                int minor = v.minor();
                System.out.println("Found Version annotation: " +
                                   "major =" + major +
                                   ", minor =" + minor);
            }
        }
        System.out.println();
    }
}
