package racing.carRun;

import org.junit.Test;
import racing.domain.CarList;
import racing.domain.CarRunRule;
import racing.domain.Game;
import racing.domain.RunRuleFactory;

import java.util.Arrays;

public class CarsRunTest {

    @Test
    public void 게임_테스트_진행_출력결과() {
        CarList cars = CarList.getByNames(Arrays.asList("abc","def","agg"));
        CarRunRule rule = RunRuleFactory.getInstance();
        Game game = Game.getInstance(cars, rule);
        game.start(6);
    }
}