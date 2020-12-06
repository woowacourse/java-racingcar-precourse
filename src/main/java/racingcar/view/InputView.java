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
    /**
     * @param scanner 입력 값
     * @return 자동차를 원소로 가진 리스트
     */
    public static ArrayList<Car> scanCars(Scanner scanner) {
        String scannerCars = scanner.nextLine();

        List<String> carNames =
                new ArrayList<>(Arrays.asList(scannerCars.split(TextType.COMMA_TEXT.getText())));
        ArrayList<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(InputUtils.validateCar(carName));
        }
        InputUtils.checkDuplicatedCar(cars);

        return cars;
    }

    /**
     * @param scanner 입력 값
     * @return 자동차 경주 게임을 시도할 횟수
     */
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
