package racingcar.domain;

import racingcar.type.TextType;

import java.util.ArrayList;

/**
 * 위치에 대한 클래스
 *
 * @author Daeun Lee
 */
public class Position {
    /**
     * @param car 자동차
     * @return 자동차의 전진을 나타내는 "-"을 가진 스트링 버퍼
     */
    public static StringBuffer drawPosition(Car car) {
        StringBuffer carPosition = new StringBuffer();

        for (int i = 0; i < car.getPosition(); i++) {
            carPosition.append(TextType.LINE_TEXT.getText());
        }

        return carPosition;
    }

    /**
     * @param cars 자동차를 원소로 가진 리스트
     * @return 자동차의 위치를 원소로 가진 리스트
     */
    public static ArrayList<Integer> extractPosition(ArrayList<Car> cars) {
        ArrayList<Integer> carPositions = new ArrayList<>();

        for (Car car : cars) {
            carPositions.add(car.getPosition());
        }

        return carPositions;
    }

    /**
     * @param carPositions 자동차의 위치를 원소로 가진 리스트
     * @return 자동차 위치 최댓값
     */
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
