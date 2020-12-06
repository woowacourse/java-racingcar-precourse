package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);
        Player player;
        GameRound gameRound;

        player = new Player(inputView.receiveCarNames());
        gameRound = new GameRound(inputView.receiveGameRound());
        OutputView.printPlayingScreen();
        player.play(gameRound);
    }
}
