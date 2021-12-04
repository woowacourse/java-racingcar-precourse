package racingcar;

import java.util.*;

public class Exception {

    public static void isNothingInput(String inputName) {
        if (inputName == "") {
            throw new IllegalArgumentException();
        }
    }

    public static void isEmptyName(String[] allCarName) {
        for (String name : allCarName) {
            if (name.contains(" ")) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void isOverlap(String[] allCarName) {
        List<String> list = Arrays.asList(allCarName);
        Set<String> set = new HashSet<>(list);

        if (list.size() != set.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isRightLength(String[] allCarName) {
        for (String name : allCarName) {
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
