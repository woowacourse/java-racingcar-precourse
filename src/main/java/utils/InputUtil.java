package utils;

import domain.Car;
import domain.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtil {
    static final Scanner SCANNER = new Scanner(System.in);
    static final String COMMA = ",";

    public static List<Car> inputRacingCars() {
        String[] carNames = SCANNER.nextLine().trim().replace(" ", "").split(COMMA);
        List<Car> Cars = new ArrayList<Car>();
        for (String carName : carNames) {
            // TODO : new 선언자로 한번에 두개 생성하는 것이 옳은가 ?
            Cars.add(new Car(new Name(carName)));
        }
        return Cars;
    }

    public static int inputCount() {
        return SCANNER.nextInt();
    }
}
