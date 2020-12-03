package racingcar;

import java.util.Scanner;

public class GameController {
    public static void playGame(Scanner scanner) {
        String[] carNames = GameInput.getCarNames(scanner);
        int gameRound = GameInput.getGameRound(scanner);
        Cars gameCars = Cars.generateCars(carNames);
        Simulator.simulateRace(gameCars, gameRound);
        Referee.judge(gameCars);
    }
}
