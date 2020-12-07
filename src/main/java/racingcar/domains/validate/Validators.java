package racingcar.domains.validate;

public class Validators {

    public static Validator getAttemptNumberInputValidator() {
        return new AttemptNumberInputValidator();
    }

    public static Validator getCarNameInputValidator() {
        return new CarNamesInputValidator();
    }

}
