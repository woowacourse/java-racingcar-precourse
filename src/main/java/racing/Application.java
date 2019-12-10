package racing;

import racing.display.InputDisplay;
import racing.display.OutputDisplay;
import racing.domain.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> names = InputDisplay.getCarNames();
        CarList cars = CarList.getByNames(names);

        int round = InputDisplay.getRound();

        CarRunRule runRule = RunRuleFactory.getInstance();
        Game game = Game.getInstance(cars, runRule);

        OutputDisplay.startPrintResult();
        for (int i = 0; i < round; i++) {
            game.playOneRound();
            OutputDisplay.printEachRoundResult(game);
        }

        Winner winner = game.getWinners();
        OutputDisplay.printResult(winner);
    }
}
