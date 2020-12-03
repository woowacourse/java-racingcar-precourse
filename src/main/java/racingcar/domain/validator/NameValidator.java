package racingcar.domain.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import racingcar.domain.CustomIllegalArgumentException;

public class NameValidator extends Validator {

    // 자동차 이름은 콤마(Comma)를 제외한 모든 문자를 1글자 이상 5글자 이하로 입력할 수 있다
    public static final Pattern NAMES_LENGTH_PATTERN = Pattern.compile("[^,]{1,5}(,[^,]{1,5})*");

    public static final String OUT_OF_BOUND_MESSAGE = "자동차 이름은 1글자 이상 5글자 이하이어야 합니다.";

    public static final String DUPLICATE_NAME_MESSAGE = "중복된 자동차 이름이 존재합니다.";

    @Override
    public void validate(String carNames) {
        super.validate(carNames);
        checkNameLength(carNames);
        checkDuplicateName(carNames);
    }

    public void checkNameLength(String carNames) {
        Matcher matcher = NAMES_LENGTH_PATTERN.matcher(carNames);
        if (!matcher.matches()) {
            throw new CustomIllegalArgumentException(OUT_OF_BOUND_MESSAGE);
        }
    }

    public void checkDuplicateName(String carNames) {
        String[] names = carNames.split(",");

        int deduplicatedNamesLength = new HashSet<>(Arrays.asList(names)).size();

        if (names.length != deduplicatedNamesLength) {
            throw new CustomIllegalArgumentException(DUPLICATE_NAME_MESSAGE);
        }
    }
}
