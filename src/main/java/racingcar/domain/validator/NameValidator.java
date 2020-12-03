package racingcar.domain.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import racingcar.domain.CustomIllegalArgumentException;

public class NameValidator extends Validator {

    // 자동차 이름은 콤마(Comma)를 제외한 모든 문자를 1글자 이상 5글자 이하로 입력할 수 있다
    public static final Pattern NAMES_LENGTH_PATTERN = Pattern.compile("[^,]{1,5}(,[^,]{1,5})*");

    public static final String OUT_OF_BOUND_MESSAGE = "자동차 이름은 1글자 이상 5글자 이하이어야 합니다.";

    @Override
    public void validate(String input) {
        super.validate(input);
        checkNameLength(input);
    }

    public void checkNameLength(String input) {
        Matcher matcher = NAMES_LENGTH_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new CustomIllegalArgumentException(OUT_OF_BOUND_MESSAGE);
        }
    }
}
