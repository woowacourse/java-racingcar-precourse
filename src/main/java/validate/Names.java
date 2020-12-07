package validate;

import static game.Rule.MAXIMUM_COUNT;
import static game.Rule.NAMES_SIZE;
import static game.Rule.NAME_DELIMITER;
import static game.Rule.NAME_LENGTH;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yhh1056
 * @since 2020/12/04
 */
public class Names extends Error {
    public static final String EXIST_WHITESPACE = "이름에 공백이 존재합니다.";
    public static final String EMPTY = "이름이 존재하지 않습니다.";
    public static final String OVER_LENGTH = "이름이 " + NAME_LENGTH + "자가 넘습니다.";
    public static final String DUPLICATE = "이름이 중복됩니다.";
    public static final String OVER_SIZE = "참가자 수가 " + MAXIMUM_COUNT + "명이 넘습니다.";

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

    private void validateEmpty(String names) {
        if (names.isEmpty() || names.endsWith(NAME_DELIMITER)) {
            throwMessage(EMPTY);
        }
    }

    private void validateWhitespace(String names) {
        if (names.contains(SPACE) || names.contains(TAB)) {
            throwMessage(EXIST_WHITESPACE);
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
                throwMessage(OVER_LENGTH);
            }
        }
    }

    private void validateDuplicate(String[] splitNames) {
        Set<String> nonDuplicateName = new HashSet<>(Arrays.asList(splitNames));
        if (splitNames.length != nonDuplicateName.size()) {
            throwMessage(DUPLICATE);
        }
    }

    private void validateNamesSize(String[] splitNames) {
        if (splitNames.length > NAMES_SIZE) {
            throwMessage(OVER_SIZE);
        }
    }
}
