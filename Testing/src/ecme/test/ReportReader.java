package ecme.test;

import java.io.IOException;
import java.sql.SQLException;

public interface ReportReader {
    public Report readReport() throws Throwable;
}
