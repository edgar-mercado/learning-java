package ecme.test;

import java.sql.SQLException;

public class ReportReaderDBImpl implements ReportReader {
    public Report readReport() throws SQLException {
        try {
            // Code that reads the report from a DB and may throw an SQLException
        	
        } catch (SQLException e) {
            System.err.println("DB error");
            throw e;
        }
        return new Report();

    }
}