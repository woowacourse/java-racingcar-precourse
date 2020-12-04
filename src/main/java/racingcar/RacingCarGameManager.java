package racingcar;

import java.util.Scanner;

public class RacingCarGameManager {
    private Player player;
    private int round;

    public RacingCarGameManager(Scanner scanner) {
        this.player = new Player(scanner);
    }

    public void startRacingCarGame() {
        player.inputCarNames();
        this.round = player.inputRoundNumber();
    }
}
