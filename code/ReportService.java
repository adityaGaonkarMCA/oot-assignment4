package dcst;

public class ReportService {
    /** Message passing: accepts any object implementing Reportable. */
    public static void printReport(Reportable item) {
        item.displayReport();
    }
}
