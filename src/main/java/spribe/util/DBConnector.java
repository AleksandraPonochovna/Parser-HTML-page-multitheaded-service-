package spribe.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/util" +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "aleksandra";
    private static final Logger logger = Logger.getLogger(DBConnector.class);

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            logger.error("The connection with DB had an SQL exception.", e);
        } catch (ClassNotFoundException e) {
            logger.error("Didn't find a Driver Class.", e);
        }
        return null;
    }

}