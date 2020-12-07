package racingcar;

public class Number {
    private static final String WRITE_APPROPRIATE_NUMBER = "[ERROR] 0이상의 숫자를 입력하세요.";

    private int tryNumber;

    Number(String string) {
        isNumber(string);
        this.tryNumber = Integer.parseInt(string);
    }

    private void isNumber(String string) {
        for (int i = 0; i < string.length(); i++) {
            checkDigit(string.charAt(i));
        }
    }

    private void checkDigit(char character) {
        if (!Character.isDigit(character)) {
            throw new IllegalArgumentException(WRITE_APPROPRIATE_NUMBER);
        }
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
