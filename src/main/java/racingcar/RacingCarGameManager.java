package racingcar;

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
    }

    private void moveCarsDuringRounds() {
        for(int current=0;current<round; current++){
            player.moveCars();
        }
    }

    private void initialize() {
        player.inputCarNames();
        this.round = player.inputRoundNumber();
    }
}
