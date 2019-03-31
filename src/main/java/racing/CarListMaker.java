package racing;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 리스트를 생성하는 클래스
 */
public class CarListMaker {
    private static final int MAX_NAME_LENGTH = 5;

    public static List<Car> getList(String undividedCarName) {
        String[] carNames = undividedCarName.split(",");
        List<Car> carList = new ArrayList<>();

        for (String carName: carNames) {
            carList.add(new Car(carName.trim()));
        }

        return carList;
    }
}
