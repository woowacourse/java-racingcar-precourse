package racingcar.domain;

import racingcar.domain.engine.Engine;

import java.util.ArrayList;
import java.util.List;

/**
 * 이 클래스는 레이스에 참여하는 자동차들을 관리하는 클래스입니다.
 * 레이스에 참여하는 자동차들을 멤버 변수로 가지고 있으며,
 * 모든 자동차에게 이동 요청과 우승자를 판별하는 책임을 수행합니다.
 *
 * @author Byeonghwa Kim
 * @version 1.0
 */
public class RacingCars {

    private List<Car> cars;
    private int fastestPosition = 0;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public String move(Engine engine) {
        StringBuilder moveResult = new StringBuilder();
        for (Car car : cars) {
            car.move(engine);
            calculateFastestPosition(car.getPosition());
            moveResult
                    .append(car.toString())
                    .append("\n");
        }
        return moveResult.toString();
    }

    private void calculateFastestPosition(int carPosition) {
        if (carPosition > fastestPosition) {
            fastestPosition = carPosition;
        }
    }

    public List<Car> getFastestCars() {
        List<Car> fastestCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == fastestPosition) {
                fastestCars.add(car);
            }
        }
        return fastestCars;
    }
}
