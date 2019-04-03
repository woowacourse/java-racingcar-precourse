import domain.InputReport;
import java.util.Vector;

public class InputErrorHandler {

    static Vector<InputReport> gatherError(Vector<String> names, int max) {
        Vector<InputReport> errors = new Vector<>();

        errors.add(Oracle.checkLength(names, max));
        errors.add(Oracle.checkRepetition(names));
        errors.add(Oracle.checkEmptyString(names));

        return errors;
    }


}
