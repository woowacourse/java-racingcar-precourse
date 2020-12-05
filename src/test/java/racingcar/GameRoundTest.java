package racingcar;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class GameRoundTest {

    @Test(expected = IllegalGameRoundException.class)
    @DisplayName("시도 횟수에 문자를 입력하면 예외 발생")
    public void testGameRoundHasCharacter() {
        new GameRound("1ab");
    }
    
    @Test(expected = IllegalGameRoundException.class)
    @DisplayName("시도 횟수에 공백을 입력하면 예외 발생")
    public void testGameRoundHasSpace() {
        new GameRound("1 5");
    }
    
    @Test(expected = IllegalGameRoundException.class)
    @DisplayName("시도 횟수에 기호를 입력하면 예외 발생")
    public void testGameRoundHasMark() {
        new GameRound("&*5");
    }
    
    @Test(expected = IllegalGameRoundException.class)
    @DisplayName("시도 횟수에 음수를 입력하면 예외 발생")
    public void testGameRoundIsNegative() {
        new GameRound("-4");
    }
    
    @Test(expected = IllegalGameRoundException.class)
    @DisplayName("시도 횟수에 소수를 입력하면 예외 발생")
    public void testGameRoundIsDouble() {
        new GameRound("2.5");
    }
    
    @Test(expected = IllegalGameRoundException.class)
    @DisplayName("시도 횟수에 0을 입력하면 예외 발생")
    public void testGameRoundIsZero() {
        new GameRound("0");
    }
}
