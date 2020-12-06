package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);
        Player player;
        GameRound gameRound;

        String carNames = inputView.receiveCarNames();
        try {
            CarValidator.validateDuplication(carNames);
        } catch (IllegalCarNameException e) {
            System.out.println(e.getMessage());
        }
        player = new Player(carNames);

        String round = inputView.receiveGameRound();
        try {
            gameRound = new GameRound(round);
            player.play(gameRound);
        } catch (IllegalGameRoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
