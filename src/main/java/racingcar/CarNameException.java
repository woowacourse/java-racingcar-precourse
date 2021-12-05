package racingcar;

import java.util.*;

public class CarNameException {
    public static void validateCarName(String[] allCarName) {
        isEmptyName(allCarName);
        isOverlap(allCarName);
        isRightLength(allCarName);
    }

    public static void isNothingInput(String inputName) {
        if (inputName == null) {
            throw new IllegalArgumentException("[ERROR] 이름이 입력되지 않았습니다.");
        }
    }

    public static void isEmptyName(String[] allCarName) {
        for (String name : allCarName) {
            if (name.contains(" ")) {
                throw new IllegalArgumentException("[ERROR] 이름에 공백이 있을 수 없습니다.");
            }
        }
    }

    public static void isOverlap(String[] allCarName) {
        List<String> list = Arrays.asList(allCarName);
        Set<String> set = new HashSet<>(list);

        if (list.size() != set.size()) {
            throw new IllegalArgumentException("[ERROR] 이름은 중복될 수 없습니다.");
        }
    }

    public static void isRightLength(String[] allCarName) {
        for (String name : allCarName) {
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 이름은 한 글자 이상 다섯 글자 이하만 가능합니다.");
            }
        }
    }
}
