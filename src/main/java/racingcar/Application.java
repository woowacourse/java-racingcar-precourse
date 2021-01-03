package racingcar;

import java.util.Scanner;

import service.GameService;
import service.InputService;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        InputService inputService = new InputService(scanner);
        runGame(inputService);

        scanner.close();
    }

    private static void runGame(InputService inputService) {
        String[] carNames = inputService.getCarNames();
        int totalPhaseNumber = inputService.getToTalPhaseNumber();
        GameService gameService = new GameService(carNames);
        System.out.println("\n실행 결과");

        for (int i = 0; i < totalPhaseNumber; i++) {
            gameService.runPhase();
        }

        gameService.showResult();
    }
}
