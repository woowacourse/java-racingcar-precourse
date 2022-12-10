package racingcar.Util;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Message.Message.WINNERS;
import static racingcar.Message.Rule.*;

public class TypeParser {

    public List<Car> toCarList(String userInput) {
        List<Car> cars = new ArrayList<>();

        for (String name : userInput.split(CAR_NAME_SEPARATOR.toString())) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public String positionToGauge(int position) {
        StringBuilder gauge = new StringBuilder();

        for (int i = 0; i < position; i++) {
            gauge.append(CAR_DRIVEN_DISTANCE_GAUGE);
        }

        return gauge.toString();
    }

    public String winners(List<Car> cars) {
        int maxDistance = 0;

        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getPosition());
        }

        return getWinners(cars, maxDistance);
    }

    private String getWinners(List<Car> cars, int maxDistance) {
        String separator = CAR_NAME_SEPARATOR.toString();
        separator += BLANK;

        StringBuilder winners = new StringBuilder(WINNERS.toString());

        for (Car car : cars) {
            if(car.getPosition() == maxDistance){
                winners.append(car.getName());
                winners.append(separator);
            }
        }

        return winners
                .substring(0, winners.lastIndexOf(separator));
    }
}
