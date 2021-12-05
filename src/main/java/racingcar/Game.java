package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;

    private final Printer printer;
    private List<Car> cars;
    private int round;

    public Game() {
        this.printer = new Printer();
        this.cars = new ArrayList<>();
        this.round = 0;
    }

    public void run() {
        Input input = new Input();

        printer.printInputNameInfo();

        List<String> names = input.inputCarNames();
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        printer.printInputRoundInfo();
        this.round = input.inputRoundNumber();

        for (int i = 0; i < round; i++) {
            runRound();
            printer.printMiddleResult(cars);
        }

        printTotalResult();
    }

    public void runRound() {
        for (Car car : cars) {
            car.goOrStop(Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER));
        }
    }

    private void printTotalResult() {
        List<String> winners = findWinners();
        printer.printWinner(winners);
    }

    private List<String> findWinners() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
