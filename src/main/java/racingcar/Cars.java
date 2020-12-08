package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static List<Car> cars;

    public Cars(ArrayList<String> cars) {
        this.cars = cars.stream().map(String::trim)
                .map(Car::new).collect(Collectors.toList());
    }

    public static void moveCars() {
        for (Car car : cars) {
            car.goOrStop(RandomUtils.nextInt(1, 9));
        }
    }

    public String getCarCurrentPosition() {
        StringBuilder carCurrentPosition = new StringBuilder();
        for (Car car : cars) {
            carCurrentPosition.append(car.getCurrentPosition());
            carCurrentPosition.append("\n");
        }
        return carCurrentPosition.toString();
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public String getWinner(int maxPosition) {
        StringBuilder winner = new StringBuilder();

        winner.append("최종 우승자: ");
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winner.append(car.getName());
                winner.append(", ");
            }
        }
        return winner.substring(0, winner.length() - 1);
    }
}
