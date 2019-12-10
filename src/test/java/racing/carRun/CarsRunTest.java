package racing.carRun;

import org.junit.Test;
import racing.display.OutputDisplay;
import racing.domain.*;

import java.util.Arrays;

public class CarsRunTest {

    @Test
    public void 게임_테스트_진행_출력결과() {
        CarList cars = CarList.getByNames(Arrays.asList("abc", "defd", "aaagg", "abcc", "aa", "ds"));
        CarRunRule rule = RunRuleFactory.getInstance();
        Game game = Game.of(cars, rule);

        for (int i = 0; i < 3; i++) {
            game.playOneRound();
            OutputDisplay.printEachRoundResult(game);
        }

        OutputDisplay.printWinners(game.getWinners());
    }
}