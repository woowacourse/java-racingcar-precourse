package racingcar;

import service.OneDigitNumberGenerator;
import service.RandomNumberGenerator;
import view.InputView;
import domain.Car;
import view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumberGenerator numberGenerator;
    private Car[] cars;

    GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        numberGenerator = new OneDigitNumberGenerator();
    }

    private void initCars(List<String> names) {
        int len = names.size();
        cars = new Car[len];

        for (int i = 0; i < len; i++) {
            cars[i] = new Car(names.get(i));
        }
    }

    public void start() {
        List<String> names = inputView.getNames();
        initCars(names);
        int gameCount = inputView.getCount();
        processGame(gameCount);
    }

    private void processGame(int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            int[] numbers = generateNumberPerCar();
            moveCars(numbers);
            outputView.printResultForOneGame(cars);
        }
    }

    private int[] generateNumberPerCar() {
        int[] numbers = new int[cars.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numberGenerator.generateRandomNumberInRange(0, 9);
        }
        return numbers;
    }

    private void moveCars(int[] numbers) {
        for (int i = 0; i < cars.length; i++) {
            cars[i].moveOrStop(numbers[i]);
        }
    }
}
