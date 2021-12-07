package racingcar;

import java.util.*;

public class CarNameException {
    public static final String NAME_ONE_SPACE = " ";
    public static final int NAME_LENGTH_LOWEST = 1;
    public static final int NAME_LENGTH_HIGHEST = 5;

    public static void validateCarName(String[] allCarName) {
        isEmptyName(allCarName);
        isOverlap(allCarName);
        isRightLength(allCarName);
    }


    public static void isEmptyName(String[] allCarName) {
        for (String name : allCarName) {
            if (name.contains(NAME_ONE_SPACE)) {
                throw new IllegalArgumentException(Constant.ERROR_EMPTY_NAME);
            }
        }
    }

    public static void isOverlap(String[] allCarName) {
        List<String> list = Arrays.asList(allCarName);
        Set<String> set = new HashSet<>(list);

        if (list.size() != set.size()) {
            throw new IllegalArgumentException(Constant.ERROR_OVERLAP_NAME);
        }
    }

    public static void isRightLength(String[] allCarName) {
        for (String name : allCarName) {
            if (name.length() < NAME_LENGTH_LOWEST || name.length() > NAME_LENGTH_HIGHEST) {
                throw new IllegalArgumentException(Constant.ERROR_RIGHT_LENGTH_NAME);
            }
        }
    }
}
