package exceptions;

import java.util.List;

public class Errors {
    private final String NAMING_RULE = "자동차 이름은 5자 이하만 가능합니다.";
    private final String PLAYER_NUMBER_RULE = "참가자는 둘 이상이어야 합니다.";
    private final String DUPLICATE_RULE = "중복되지 않는 이름을 입력해 주세요.";
    private final String TRIAL_RULE = "1 이상의 숫자만 입력할 수 있습니다.";
    private char temp;

    public void nameValidation(String name) throws RacingException {
        if (name.length() > 5) {
            throw new RacingException(NAMING_RULE);
        }
    }

    public void nameDuplication(List<String> names, String name) throws RacingException {
        int cnt = 0;
        for (String s : names) {
            if (s.equals(name)) {
                cnt++;
            }
        }
        if (cnt > 1) {
            throw new RacingException(DUPLICATE_RULE);
        }
    }

    public void playerNumberValidation(List<String> names) throws RacingException {
        if (names.size() < 2) {
            throw new RacingException(PLAYER_NUMBER_RULE);
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
