package racingcar;

import racingcar.Car.Cars;

import java.util.List;

public class Racing {
    private static final String COMMA_AND_SPACE = ", ";
    private static final String FINAL_WINNER_MSG = "최종 우승자 : ";
    private static final String ROUND_INFORMATION_MSG_FORMAT = "======= %d 라운드 =======" + System.lineSeparator();

    private Cars cars;
    private int totalRound;
    private int round;

    public Racing(Cars cars, int totalRound) {
        this.cars = cars;
        this.totalRound = totalRound;
        this.round = 0;
    }

    public boolean hasNextRound() {
        return round < totalRound;
    }

    public void nextRound() {
        cars.race();
        round++;
    }

    public String printProgress() {
        return String.format(ROUND_INFORMATION_MSG_FORMAT, round).concat(cars.printProgress());
    }

    public String printResult() {
        List<String> winners = cars.findWinners();
        return FINAL_WINNER_MSG + String.join(COMMA_AND_SPACE, winners);
    }

}
