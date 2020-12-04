package racingcar;

import java.util.List;

public class Racing {
    public static final String COMMA_AND_SPACE = ", ";
    public static final String FINAL_WINNER_MSG = "최종 우승자 : ";
    private Cars cars;
    private int round;

    public Racing(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public boolean hasNextRound() {
        return round > 0;
    }

    public void nextRound() {
        cars.race();
        round--;
    }

    public String printProgress() {
        return cars.printProgress();
    }

    public String printResult() {
        List<String> winners = cars.getWinners();
        return FINAL_WINNER_MSG + String.join(COMMA_AND_SPACE, winners);
    }

}
