package ecme.test;

import java.io.IOException;

public class ReportReaderFileImpl implements ReportReader {
    public Report readReport() throws IOException {
        try {
            // Code that reads the report from a file and may throw an IOException
        } catch (IOException e) {
            System.err.println("File error");
            throw e;
        }
        return new Report();
    }
}