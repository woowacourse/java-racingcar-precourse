package utils.validator;

public class InputValidator {
    private NameValidator nameValidator;
    private TimeValidator timeValidator;

    public InputValidator() {
        nameValidator = new NameValidator();
        timeValidator = new TimeValidator();
    }

    public String[] validNames(String inputNames) {
        if (!nameValidator.validDelimiter(inputNames)) {
            return null;
        }

        String[] names = inputNames.split(nameValidator.DELIMITER);

        if (!nameValidator.validLength(names)) {
            return null;
        }

        if (!nameValidator.validCharacter(names)) {
            return null;
        }

        if (nameValidator.duplicate(names)) {
            return null;
        }

        return names;
    }

    public boolean invalidTime(String time) {
        if (time.isEmpty()) {
            return true;
        }

        if (!timeValidator.isDigit(time)) {
            return true;
        }

        if (timeValidator.isZero(time)) {
            return true;
        }

        if (timeValidator.isNegative(time)) {
            return true;
        }

        return false;
    }
}
