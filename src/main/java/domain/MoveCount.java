package domain;

public class MoveCount {
    public static final int MOVE_COUNT_MIN_NUMBER = 1;
    private final int value;

    public MoveCount(String input) throws IllegalArgumentException {
        if (isInvalidNumber(input)) {
            throw new IllegalArgumentException(String.format("※%d 이상의 숫자만 입력할 수 있습니다.", MOVE_COUNT_MIN_NUMBER));
        }
        this.value = Integer.parseInt(input);
    }

    private static boolean isNotNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char inputCharacter = input.charAt(i);
            if (inputCharacter < '0' || '9' < inputCharacter) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInvalidNumber(String input) {
        if (isNotNumber(input)) {
            return true;
        }
        int number = Integer.parseInt(input);
        return !(MOVE_COUNT_MIN_NUMBER <= number);
    }

    public int get() {
        return this.value;
    }
}
