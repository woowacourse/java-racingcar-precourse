package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameUtil {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int PIVOT = 4;
    private static final String COMMA = ",";

    public static int findMax(List<Car> cars) {
        List<Integer> position = new ArrayList<>();
        for (Car car : cars) {
            position.add(car.getPosition());
        }
        return Collections.max(position);
    }

    public static void tryMove(Car car) {
        if (canMove()) {
            car.goForward();
        }
    }

    private static boolean canMove() {
        return (Randoms.pickNumberInRange(START_NUMBER, END_NUMBER) >= PIVOT);
    }

    public static List<Car> parseStringToList(List<Car> cars, String input) {
        String[] carNames = input.split(COMMA);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
