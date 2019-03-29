package domain;

import domain.interfaces.InputValidator;
import domain.interfaces.NumberGenerator;
import domain.interfaces.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private static final int MOVING_POSITION_PER_GO = 1;

    private NumberGenerator numberGenerator;
    private InputValidator inputValidator;
    private UserInterface ui;
    private boolean isEnd = false;
    private boolean shouldGetInput = true;
    private List<Car> cars;
    private int progressCount;
    private int currentProgress = 0;

    public Player(NumberGenerator generator, InputValidator validator, UserInterface ui) {
        numberGenerator = generator;
        inputValidator = validator;
        this.ui = ui;
    }

    public void doLoop() {
        currentProgress++;
        checkInput();

        for (Car c : cars) {
            c.moveForward(calculatePositionToMove());
        }
        ui.printProgress(cars);

        if (currentProgress == progressCount) {
            List<Car> winners = calculateWinners();
            ui.printWinners(winners);
            isEnd = true;
        }
    }

    private void checkInput() {
        if (!shouldGetInput) {
            return;
        }

        initCarList();
        initProgressCount();
        shouldGetInput = false;
    }

    private void initCarList() {
        String[] names = ui.promptCarNames();
        cars = new ArrayList<>();

        while (!isValidCarNames(names)) {
            ui.notifyInvalidCarNamesInput();
            names = ui.promptCarNames();
        }

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void initProgressCount() {
        progressCount = ui.promptProgressCount();

        while (!inputValidator.isValidProgressCount(progressCount)) {
            ui.notifyInvalidProgressCountInput();
            progressCount = ui.promptProgressCount();
        }
    }

    private boolean isValidCarNames(String[] names) {
        for (String name : names) {
            if (!inputValidator.isValidCarName(name)) {
                return false;
            }
        }

        return true;
    }

    private List<Car> calculateWinners() {
        Car winner = cars.stream().max(Car::compareTo).get();
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == winner.getPosition())
                .collect(Collectors.toList());
        return winners;
    }

    private int calculatePositionToMove() {
        StopOrGo stopOrGo = StopOrGo.valueOf(numberGenerator.getNumber());
        if (stopOrGo == StopOrGo.GO) {
            return MOVING_POSITION_PER_GO;
        }
        if (stopOrGo == StopOrGo.STOP) {
            return 0;
        }

        throw new IllegalStateException();
    }

    public boolean isEnd() {
        return isEnd;
    }

}
