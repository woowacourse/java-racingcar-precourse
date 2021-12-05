package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Car> lineup;
    private List<String> winners;
    private Staff staff;
    private Judge judge;

    public Racing() {
        this.lineup = new ArrayList<>();
        this.staff = new Staff();
        this.judge = new Judge();
    }

    public void start() {
        String[] waitingCarNames = staff.collectCarNames();
        enrollCars(waitingCarNames);

        Integer repeatTimes = staff.collectRepeatTimes();
        repeatRace(repeatTimes);

        winners = judge.findWinners(lineup);
        staff.awardWinners(winners);
    }

    private void enrollCars(String[] waitingCarNames) {
        for (String carName : waitingCarNames) {
            Car car = new Car(carName);
            lineup.add(car);
        }
    }

    private void repeatRace(Integer repeatTimes) {
        staff.startRace();
        int round = 0;
        while (round < repeatTimes) {
            for (Car car : lineup) {
                car.goOrStop();
            }
            staff.announceScoreBoard(lineup);
            round++;
        }
    }
}
