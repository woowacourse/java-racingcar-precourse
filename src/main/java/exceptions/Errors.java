package exceptions;

public class Errors {
    private final String NAMING_RULE = "자동차 이름은 5자 이하만 가능합니다.";
    private final String TRIAL_RULE = "1 이상의 숫자만 입력할 수 있습니다.";
    private char temp;

    public void nameValidation(String name) throws RacingException {
        if (name.length() > 5) {
            throw new RacingException(NAMING_RULE);
        }
    }

    public void trialValidation(String input) throws RacingException {
        for (int i=0; i<input.length(); i++) {
            temp = input.charAt(i);
            if (!Character.isDigit(temp)) {
                throw new RacingException(TRIAL_RULE);
            }
        }

        if (Integer.parseInt(input) < 0) {
            throw new RacingException(TRIAL_RULE);
        }
    }

}
