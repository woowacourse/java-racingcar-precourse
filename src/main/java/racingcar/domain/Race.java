package racingcar.domain;

import racingcar.domain.engine.RandomEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * 이 클래스는 레이스를 주관하는 클래스입니다.
 * 레이스에 참여하는 레이싱 자동차들, 이동하는 횟수를 멤버 변수로 가지고 있으며,
 * 자동차들에게 이동 요청을 하고, 레이스 결과를 기록하는 책임을 수행합니다.
 *
 * @author Byeonghwa Kim
 * @version 1.0
 */
public class Race {

    private static final String WINNNING_CARS_MSG = "최종 우승자: ";

    private RacingCars racingCars;
    private int numOfMove;
    private StringBuilder racingResult = new StringBuilder();

    public Race(List<String> carsNames, int numOfMove) {
        prepareRacingCars(carsNames);
        this.numOfMove = numOfMove;
    }

    private void prepareRacingCars(List<String> carsNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carsNames) {
            cars.add(new Car(carName));
        }
        this.racingCars = new RacingCars(cars);
    }

    public void start() {
        RandomEngine randomEngine = new RandomEngine();

        for (int i = 0; i < numOfMove; i++) {
            racingResult
                    .append(racingCars.move(randomEngine))
                    .append("\n");
        }

        racingResult
                .append(WINNNING_CARS_MSG)
                .append(getFastestCarsName());
    }

    private String getFastestCarsName() {
        List<Car> fastestCars = racingCars.getFastestCars();

        int numOfFastestCar = fastestCars.size();
        String[] fastestCarsName = new String[numOfFastestCar];
        for (int i = 0; i < numOfFastestCar; i++) {
            fastestCarsName[i] = fastestCars.get(i).getName();
        }

        return String.join(",", fastestCarsName);
    }

    public String getRacingResult() {
        return this.racingResult.toString();
    }
}
