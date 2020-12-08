package exceptions;

public class Errors {
    private final String NAMING_RULE = "자동차 이름은 5자 이하만 가능합니다.";

    public void nameValidation(String name) throws RacingException {
        if (name.length() > 5) {
            throw new RacingException(NAMING_RULE);
        }
    }
}
