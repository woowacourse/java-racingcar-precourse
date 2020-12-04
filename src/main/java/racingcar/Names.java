package racingcar;

import static racingcar.Rule.NAMES_SIZE;
import static racingcar.Rule.NAME_DELIMITER;
import static racingcar.Rule.NAME_LENGTH;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yhh1056
 * @since 2020/12/04
 */
public class Names {
    private static final CharSequence TAB = "\t";
    private static final String SPACE = " ";

    public List<String> validate(String names) {
        return validateName(names);
    }

    private List<String> validateName(String names) {
        validateEmpty(names);
        validateWhitespace(names);
        return validateNames(names.split(NAME_DELIMITER));
    }

    private void validateWhitespace(String names) {
        if (names.contains(SPACE) || names.contains(TAB)) {
            throw new IllegalArgumentException("[ERROR] 이름에 공백이 존재합니다.");
        }
    }

    private void validateEmpty(String names) {
        if (names.isEmpty() || names.endsWith(NAME_DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 이름이 존재하지 않습니다.");
        }
    }

    private List<String> validateNames(String[] splitNames) {
        validateNameLength(splitNames);
        validateDuplicate(splitNames);
        validateNamesSize(splitNames);
        return Arrays.asList(splitNames);
    }

    private void validateNameLength(String[] splitNames) {
        for (String name : splitNames) {
            if (name.length() > NAME_LENGTH) {
                throw new IllegalArgumentException("[ERROR] 이름이 5자가 넘습니다.");
            }
        }
    }

    private void validateDuplicate(String[] splitNames) {
        Set<String> nonDuplicateName = new HashSet<>(Arrays.asList(splitNames));
        if (splitNames.length != nonDuplicateName.size()) {
            throw new IllegalArgumentException("[ERROR] 이름이 중복됩니다.");
        }
    }

    private void validateNamesSize(String[] splitNames) {
        if (splitNames.length > NAMES_SIZE) {
            throw new IllegalArgumentException("[ERROR] 참가자 수가 30명이 넘습니다.");
        }
    }
}
