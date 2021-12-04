package racingcar;

public class GameRule implements RaceGame.InputChecker {
    public void checkCarName(String input) {
        if (input.length() > GameData.MAX_CAR_NAME_LENGTH) {
            throwIllegalArgumentException();
        }
    }

    public void checkTryNumber(String input) {
        for (char ch : input.toCharArray()) {
            if (isNumeric(ch)) {
                throwIllegalArgumentException();
            }
        }
    }

    public void throwIllegalArgumentException() {
        System.out.print(GameData.MESSAGE_ERROR);
        throw new IllegalArgumentException();
    }

    public boolean isNumeric(char ch) {
        return ('0' <= ch && ch <= '9');
    }
}