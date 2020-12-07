package racingcar.race;

import racingcar.Constant;
import racingcar.car.Car;
import racingcar.car.ParticipatingCars;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    public List<String> findWinner(ParticipatingCars allRacingCars, int leadPosition) {
        List<String> winners = new ArrayList<>();

        for (Car car : allRacingCars.getCars()) {
            if (car.isWinner(leadPosition)) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public void printWinner(List<String> winners) {
        System.out.print(Constant.FINAL_WINNER);

        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));

            if (i != winners.size() - 1) {
                System.out.print(Constant.COMMA);
            }
        }
    }
}
