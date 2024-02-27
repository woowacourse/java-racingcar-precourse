package racingcar;

import java.util.List;

public class Service {
    private final Util util = new Util();

    public Car[] saveCars(String input) throws IllegalArgumentException {
        String[] carsNames = util.parseCars(input);

        return util.createCars(carsNames);
    }

    public void doRace(Car[] cars) throws IllegalArgumentException {
        for (Car car : cars) {
            car.attemptRace();
        }
    }

    public int changeCount(String input) throws IllegalArgumentException {
        return util.changeCount(input);
    }

    public String findWinners(Car[] cars) {
        List<Car> winners = util.findWinners(cars);

        return util.makeWinnerFormat(winners);
    }
}
