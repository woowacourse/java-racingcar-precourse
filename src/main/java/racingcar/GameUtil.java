package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameUtil {

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
        return (Randoms.pickNumberInRange(CONSTANT.START_NUMBER, CONSTANT.END_NUMBER) >= CONSTANT.PIVOT);
    }

    public static List<Car> parseStringToList(List<Car> cars, String input) {
        String[] carNames = input.split(CONSTANT.COMMA);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
