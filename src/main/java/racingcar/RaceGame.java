package racingcar;

public class RaceGame {
    private final InputChecker inputChecker = new GameRule();

    public interface InputChecker {
        public void checkCarName(String input);

        public void checkTryNumber(String input);
    }
}
