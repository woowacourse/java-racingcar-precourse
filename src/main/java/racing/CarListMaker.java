/**
 * class : CarListMaker.java
 *
 * version : 1.0
 *
 * date : 2019.03.31
 *
 * author : icarus8050
 */

package racing;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 리스트를 생성하는 클래스
 */
public class CarListMaker {

    public static List<Car> getList(String undividedCarName) {
        String[] carNames = undividedCarName.split(",");
        List<Car> carList = new ArrayList<>();

        for (String carName: carNames) {
            carList.add(new Car(carName.trim()));
        }

        return carList;
    }
}
