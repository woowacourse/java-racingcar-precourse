package racingcar;

import java.util.Scanner;

public class GameController {
    public static void playGame(Scanner scanner) {
        String[] carNames = GameInput.getCarNames(scanner);
        int gameRound = GameInput.getGameRound(scanner);
        Car[] gameCars = generateCars(carNames);
        Simulator.simulateRace(gameCars, gameRound);
    }

    public static Car[] generateCars(String[] carNames) {
        Car[] gameCars = new Car[carNames.length];
        for (int i=0; i < carNames.length; i++){
            gameCars[i] = new Car(carNames[i]);
        }
        return gameCars;
    }
}
