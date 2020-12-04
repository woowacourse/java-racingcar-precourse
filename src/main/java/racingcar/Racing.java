package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    public static final String COMMA_AND_SPACE = ", ";
    public static final String FINAL_WINNER_MSG = "최종 우승자 : ";
    public static final String COLON_WRAPPED_BLANK = " : ";
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
            progress.append(car.getName()).append(COLON_WRAPPED_BLANK).append(revertPositionToDash(car.getPosition())).append(System.lineSeparator());
        }
        return progress.toString();
    }

    public String printResult() {
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

        return FINAL_WINNER_MSG + String.join(COMMA_AND_SPACE, winners);
    }

    private String revertPositionToDash(int position) {
        StringBuffer dash = new StringBuffer();
        for (int i = 0; i < position; i++) {
            dash.append("-");
        }
        return dash.toString();
    }
}
