package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();
        GameController gameController = new GameController(inputView, outputView);

        run(gameController);
    }

    public static void run(GameController gameController) {
        setPlayers(gameController);
        setRounds(gameController);
        playGame(gameController);
    }

    public static void setPlayers(GameController gameController) {

        try {
            gameController.registerCars();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setPlayers(gameController);
        }

    }

    public static void setRounds(GameController gameController) {

        try {
            gameController.setGameRounds();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setRounds(gameController);
        }

    }

    public static void playGame(GameController gameController) {
        gameController.startRace();
    }
}
