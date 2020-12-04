package racingcar;

import java.util.List;

public class Racing {
    private List<Car> cars;
    private int round;

    public Racing(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public boolean hasNextRound() {
        return round > 0;
    }

    public void nextRound() {
        for (Car car : cars) {
            car.race();
        }
        round--;
    }

    public String printProgress() {
        StringBuffer progress = new StringBuffer();
        for (Car car : cars) {
            progress.append(car.getName()).append(" : ").append(revertPositionToDash(car.getPosition())).append(System.lineSeparator());
        }
        return progress.toString();
    }

    private String revertPositionToDash(int position) {
        StringBuffer dash = new StringBuffer();
        for (int i = 0; i < position; i++) {
            dash.append("-");
        }
        return dash.toString();
    }
}
