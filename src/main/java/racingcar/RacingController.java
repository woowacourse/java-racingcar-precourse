package racingcar;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author yhh1056
 * @since 2020/12/02
 */
public class RacingController {
    private Input input;
    private User user;
    private RacingGame racingGame;

    public RacingController(Scanner scanner) {
        this.input = new Input(scanner);
        this.user = new User();
    }

    public void playGame() {
        readyGame();
        start();
        showWinners();
    }

    private void readyGame() {
        racingGame = new RacingGame(createCars());
    }

    private List<Car> createCars() {
        input.showInputNameMessage();
        return registerCars(user.createNames(input.nextLine()));
    }

    private List<Car> registerCars(List<String> names) {
        return names.stream().map(Car::new).collect(Collectors.toList());
    }

    private void start() {
        racingGame.startRace(createGameCount());
    }

    private int createGameCount() {
        return user.createCount(input.nextLine());
    }

    private void showWinners() {
        racingGame.findWinners();
    }
}
