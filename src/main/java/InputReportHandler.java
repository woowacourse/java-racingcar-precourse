import domain.InputReport;
import java.util.Vector;

public class InputReportHandler {

    static Vector<InputReport> gatherReports(Vector<String> names, int max) {
        Vector<InputReport> reports = new Vector<>();

        reports.add(Oracle.checkLength(names, max));
        reports.add(Oracle.checkRepetition(names));
        reports.add(Oracle.checkEmptyString(names));

        return reports;
    }


}
