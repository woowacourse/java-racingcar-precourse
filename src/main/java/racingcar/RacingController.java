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
        List<Car> cars = registerCars(user.createNames(input.nextLine()));
        int gameCount = user.createGameCount(input.nextLine());
        racingGame = new RacingGame(cars);
        racingGame.startRace(gameCount);
    }

    private List<Car> registerCars(List<String> names) {
        return names.stream().map(Car::new).collect(Collectors.toList());
    }
}
