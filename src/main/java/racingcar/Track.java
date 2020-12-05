package racingcar;

import java.util.ArrayList;
import java.util.Scanner;
import utils.InputUtils;
import utils.OutputUtils;

public class Track {

    private ArrayList<Car> cars;
    private ArrayList<String> winners;
    private int loopTime;

    public Track(ArrayList<Car> cars, ArrayList<String> winners) {
        this.cars = cars;
        this.winners = winners;
    }

    public void start(Scanner scanner) {
        tryEnrollCars(scanner);
        tryEnrollLoopTime(scanner);
        playRacing();
        awardWinners();

    }

    private void awardWinners() {
        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxDistance) {
                maxDistance = car.getPosition();
                winners.clear();
            }
            if (car.getPosition() == maxDistance) {
                winners.add(car.getName());
            }
        }
        OutputUtils.printWinners(winners);
    }

    private void playRacing() {
        for (int i = 0; i < loopTime; i++) {
            forwardCars();
        }
    }

    private void forwardCars() {
        for (Car car : cars) {
            car.tryForward();
        }
    }

    private void tryEnrollCars(Scanner scanner) {
        try {
            OutputUtils.printPleaseInputCarNames();
            enrollCars(InputUtils.inputCarNames(scanner));
        } catch (IllegalArgumentException e) {
            OutputUtils.printError(e.getMessage());
            tryEnrollCars(scanner);
        }
    }

    private void enrollCars(ArrayList<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName, new GasTank()));
        }
    }

    private void tryEnrollLoopTime(Scanner scanner) {
        try {
            OutputUtils.printPleaseInputLoopTime();
            loopTime = InputUtils.inputLoopTime(scanner);
        } catch (IllegalArgumentException e) {
            OutputUtils.printError(e.getMessage());
            tryEnrollLoopTime(scanner);
        }
    }
}
