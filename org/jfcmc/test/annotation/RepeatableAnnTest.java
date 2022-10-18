package org.jfcmc.test.annotation;

// import java.lang.annotation.Annotation;
// import java.lang.reflect.AnnotatedElement;
// import java.lang.reflect.Method;
import org.jfcmc.annotation.Version;
import org.jfcmc.annotation.ChangeLog;
import org.jfcmc.annotation.ChangeLogs;

@ChangeLog(date = "02/01/2014", comments = "Declared class")
@ChangeLog(date = "02/21/2014", comments = "Added main() method")
public class RepeatableAnnTest {
    public static void main(String[] args) {

        Class<RepeatableAnnTest> mainClass = RepeatableAnnTest.class;
        Class<ChangeLog> annClass = ChangeLog.class;

        System.out.println("Using the ChangeLog type..." );
        ChangeLog[] annList = mainClass.getAnnotationsByType(annClass);// (ChangeLog.class);
        for (ChangeLog log: annList) {
            System.out.println("Date=" + log.date() +
                               ", Comments=" + log.comments());
        }

        System.out.println("\nUsing the ChangeLogs type...");
        Class<ChangeLogs> containingAnnClass = ChangeLogs.class;
        ChangeLogs logs = mainClass.getAnnotation(containingAnnClass);
        for (ChangeLog log : logs.value()) {
            System.out.println("Date=" + log.date() +
                               ", Comments=" + log.comments());
        }
    }
}
