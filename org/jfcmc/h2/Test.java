package org.jfcmc.h2;

import java.sql.*;

public class Test {
    public static void main(String[] a)
            throws Exception {
        // jdbc:h2:~/test
        // but I launched a h2 console
        Connection conn = DriverManager.
            getConnection("jdbc:h2:http://localhost:8082/~test", "sa", "");
        // add application code here
        conn.close();
    }
}
