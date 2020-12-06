package racingcar.domain;

import racingcar.type.BoundaryType;

/**
 * 자동차에 대한 클래스
 *
 * @author Daeun Lee
 */
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    /**
     * @param car 자동차
     */
    public static void moveCar(Car car) {
        int randomNumber = RandomNumber.generateRandomNumber();

        if ((BoundaryType.MINIMUM_MOVE_NUMBER.getBoundary() <= randomNumber)
                && (randomNumber <= BoundaryType.MAXIMUM_MOVE_NUMBER.getBoundary())) {
            // 자동차는 전진한다.
            car.movePosition();
        }

        if ((BoundaryType.MINIMUM_STOP_NUMBER.getBoundary() <= randomNumber)
                && (randomNumber <= BoundaryType.MAXIMUM_STOP_NUMBER.getBoundary())) {
            // 자동차는 멈춘다.
            return;
        }
    }

    public void movePosition() {
        position++;
    }
}
