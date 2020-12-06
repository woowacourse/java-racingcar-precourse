package racingcar.model;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int THRESHOLD = 3;
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String PROGRESS_BAR = "-";
    private static final String RESULT_FORMAT = "%s : %s\n";

    private List<Car> cars;

    public RacingCarGame() {
        cars = new ArrayList<>();
    }

    public void createCar(String carNames) {
        for (String carName : carNames.split(CAR_NAME_DELIMITER)) {
            cars.add(new Car(carName));
        }
    }

    private int generateRandomNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    public void tryToMoveCar() {
        for (Car car : cars) {
            if (generateRandomNumber() > THRESHOLD) {
                car.moveForward();
            }
        }
    }

    private String createProgressBar(int position) {
        StringBuilder progressBar = new StringBuilder();
        while (position-- > 0) {
            progressBar.append(PROGRESS_BAR);
        }
        return progressBar.toString();
    }

    private String createResult(String name, int position) {
        String progressBar = createProgressBar(position);
        return String.format(RESULT_FORMAT, name, progressBar);
    }

    public String sendResult() {
        StringBuilder resultSet = new StringBuilder();
        for (Car car : cars) {
            String result = createResult(car.name(), car.position());
            resultSet.append(result);
        }
        return resultSet.toString();
    }

    public String selectWinner() {
        List<String> winners = new ArrayList<>();
        int greatestPosition = 0;
        for (Car car : cars) {
            if (greatestPosition > car.position()) {
                continue;
            }
            if (greatestPosition < car.position()) {
                greatestPosition = car.position();
                winners.clear();
            }
            winners.add(car.name());
        }
        return String.join(CAR_NAME_DELIMITER, winners);
    }
}
