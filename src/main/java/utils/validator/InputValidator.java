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

        if (!nameValidator.validLength(names) || !nameValidator.validCharacter(names) || nameValidator.duplicate(names)) {
            return null;
        }

        return names;
    }

    public boolean invalidTime(String time) {
        if (time.isEmpty()) {
            return true;
        }

        if (!timeValidator.isDigit(time) || timeValidator.isZero(time) || timeValidator.isNegative(time)) {
            return true;
        }

        return false;
    }
}
