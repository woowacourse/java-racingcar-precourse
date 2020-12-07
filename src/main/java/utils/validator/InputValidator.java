package utils.validator;

public class InputValidator {
    private NameValidator nameValidator;

    public InputValidator() {
        nameValidator = new NameValidator();
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

        return names;
    }
}
