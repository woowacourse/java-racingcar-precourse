package racingcar.view;

import racingcar.domain.Car;
import racingcar.type.ErrorType;
import racingcar.type.TextType;
import utils.InputUtils;

import java.util.*;

/**
 * 입력을 위한 클래스
 *
 * @author Daeun Lee
 */
public class InputView {
    public static ArrayList<Car> scanCars(Scanner scanner) {
        String scannerCars = scanner.nextLine();

        List<String> carNames = new ArrayList<>(
                Arrays.asList(scannerCars.split(TextType.COMMA_TEXT.getText())));
        ArrayList<Car> cars = new ArrayList<>();

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
