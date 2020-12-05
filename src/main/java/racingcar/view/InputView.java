package racingcar.view;

import racingcar.Car;
import racingcar.type.ErrorType;
import racingcar.type.TextType;
import utils.InputUtils;

import java.util.*;

public class InputView {

    public static ArrayList<Car> scanCars(ArrayList<Car> cars, Scanner scanner) {
        String scannerCars = scanner.nextLine();
        List<String> carNames = new ArrayList<>(Arrays.asList(scannerCars.split(TextType.COMMA_TEXT.getText())));
        for (String carName : carNames) {
            cars.add(InputUtils.validateCar(carName));
        }
        InputUtils.checkDuplicatedCar(cars);

        return cars;
    }

    public static int scanTimes(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println(ErrorType.INVALID_CHARACTER.getError());
        }
        int scannerTimes = scanner.nextInt();
        InputUtils.validateTimes(scannerTimes);

        return scannerTimes;
    }
}
