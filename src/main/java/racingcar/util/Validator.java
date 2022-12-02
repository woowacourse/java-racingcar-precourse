package racingcar.util;

public class Validator {
    private final int NAME_BOUNDARY = 5;

    public void validateNames(String[] names) {
        for (String name : names) {
            if (name.length() > NAME_BOUNDARY) {
                throw new IllegalArgumentException();
            }
        }
    }
}
