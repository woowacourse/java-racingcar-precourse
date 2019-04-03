import domain.InputError;
import java.util.Vector;

public class InputErrorHandler {

    static Vector<InputError> gatherError(Vector<String> names, int max) {
        Vector<InputError> errors = new Vector<>();

        errors.add(Oracle.checkLength(names, max));
        errors.add(Oracle.checkRepetition(names));
        errors.add(Oracle.checkEmptyString(names));

        return errors;
    }

}
