package racingcar;

import java.util.List;

public class CarRacingRepeat {

    public static void repeatCarRacing(List<Car> carList) {

        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).increasePosition();
            System.out.printf("%s : ", carList.get(i).getCarName());
            CarRacingPrint.printCarRacing(carList.get(i).getPosition());
            System.out.println();
        }
        System.out.println();
    }
}
