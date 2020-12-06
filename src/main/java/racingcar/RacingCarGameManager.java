package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingCarGameManager {
    private Player player;
    private int round;

    public RacingCarGameManager(Scanner scanner) {
        this.player = new Player(scanner);
    }

    public void startRacingCarGame() {
        initialize();
        moveCarsDuringRounds();
        findWinners();
    }

    private void findWinners() {
        List<Car> winningCars = player.findWinningCars();
        WinningCarsOutput.announceWinningCars(winningCars);
    }

    private void moveCarsDuringRounds() {
        for (int current = 0; current < round; current++) {
            player.moveCars();
            player.askToCarsCurrentPosition();
        }
    }

    private void initialize() {
        player.inputCarNames();
        this.round = player.inputRoundNumber();
    }
}
