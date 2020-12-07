package racingcar;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class GameRoundValidatorTest {
    @Test(expected = IllegalGameRoundException.class)
    @DisplayName("시도 횟수에 문자를 입력하면 예외 발생")
    public void testGameRoundHasCharacter() {
        GameRoundValidator.validateGameRound("1ab");
    }

    @Test(expected = IllegalGameRoundException.class)
    @DisplayName("시도 횟수에 공백을 입력하면 예외 발생")
    public void testGameRoundHasSpace() {
        GameRoundValidator.validateGameRound("1 5");
    }

    @Test(expected = IllegalGameRoundException.class)
    @DisplayName("시도 횟수에 기호를 입력하면 예외 발생")
    public void testGameRoundHasMark() {
        GameRoundValidator.validateGameRound("&*5");
    }

    @Test(expected = IllegalGameRoundException.class)
    @DisplayName("시도 횟수에 음수를 입력하면 예외 발생")
    public void testGameRoundIsNegative() {
        GameRoundValidator.validateGameRound("-4");
    }

    @Test(expected = IllegalGameRoundException.class)
    @DisplayName("시도 횟수에 소수를 입력하면 예외 발생")
    public void testGameRoundIsDouble() {
        GameRoundValidator.validateGameRound("2.5");
    }

    @Test(expected = IllegalGameRoundException.class)
    @DisplayName("시도 횟수에 0을 입력하면 예외 발생")
    public void testGameRoundIsZero() {
        GameRoundValidator.validateGameRound("0");
    }
}
