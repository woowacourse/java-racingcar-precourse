package racingcar;

import java.util.List;

public class Racing {
    private List<Car> cars;
    private int round;

    public Racing(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public boolean hasNextRound(){
        return round > 0;
    }

    public void nextRound(){
        round--;
    }

    public String printResult() {
        return "결과물";
    }
}
