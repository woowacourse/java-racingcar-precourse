package racingcar;

import java.util.List;

public class CarRacingRepeat {

    public static void repeatCarRacing(List<Car> carList) {
        for (Car car : carList) {
            car.increasePosition();
            System.out.printf("%s : ", car.getCarName());
            CarRacingPrint.printCarRacing(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }
}
