package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final String COLON_WRAPPED_BLANK = " : ";
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;

    private List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            car.race(RandomUtils.nextInt(MIN_VALUE, MAX_VALUE));
        }
    }

    public String printProgress() {
        StringBuffer progress = new StringBuffer();
        for (Car car : cars) {
            progress.append(car.getName()).append(COLON_WRAPPED_BLANK).append(revertPositionToDash(car.getPosition())).append(System.lineSeparator());
        }
        return progress.toString();
    }

    public List<String> findWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private String revertPositionToDash(int position) {
        StringBuffer dash = new StringBuffer();
        for (int i = 0; i < position; i++) {
            dash.append("-");
        }
        return dash.toString();
    }
}
