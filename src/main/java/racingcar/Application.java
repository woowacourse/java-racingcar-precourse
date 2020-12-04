package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String[] carName = scanner.next().split(",");
        System.out.println(Arrays.toString(carName));
        List<Car> carList = createCarList(carName);
        System.out.println("test");
    }

    private static List<Car> createCarList(String[] carName) {
        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carName.length; i++) {
            Car car = new Car(carName[i]);
            car.carNameValidate();
        }
        return carList;
    }
}
