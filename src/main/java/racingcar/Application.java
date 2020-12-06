package racingcar;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);
        Player player;
        GameRound gameRound;

        List<String> carNames = inputView.receiveCarNames();
        player = new Player(carNames);

        String round = inputView.receiveGameRound();
        try {
            gameRound = new GameRound(round);
            OutputView.printPlayingScreen();
            player.play(gameRound);
        } catch (IllegalGameRoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
