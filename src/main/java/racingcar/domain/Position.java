package racingcar.domain;

import racingcar.type.TextType;

import java.util.ArrayList;

/**
 * 위치에 대한 클래스
 *
 * @author Daeun Lee
 */
public class Position {
    public static StringBuffer countPosition(Car car) {
        StringBuffer carPosition = new StringBuffer();

        for (int i = 0; i < car.getPosition(); i++) {
            carPosition.append(TextType.LINE_TEXT.getText());
        }

        return carPosition;
    }

    public static ArrayList<Integer> addPosition(ArrayList<Car> cars) {
        ArrayList<Integer> carPositions = new ArrayList<>();

        for (Car car : cars) {
            carPositions.add(car.getPosition());
        }

        return carPositions;
    }

    public static int calculateMaxPosition(ArrayList<Integer> carPositions) {
        int maxPosition = 1;

        for (int currentPosition : carPositions) {
            if (maxPosition <= currentPosition) {
                maxPosition = currentPosition;
            }
        }

        return maxPosition;
    }
}
