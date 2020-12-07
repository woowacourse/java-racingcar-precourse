package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);

        Player player = new Player(inputView.receiveCarNames());
        GameRound gameRound = new GameRound(inputView.receiveGameRound());
        player.play(gameRound);
    }
}
