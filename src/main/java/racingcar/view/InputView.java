package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String input_Car_Names_Message = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private InputView() {
    }

    public static Cars inputCarNames(Scanner scanner) {
        try {
            System.out.println(input_Car_Names_Message);
            String[] carNames = scanner.nextLine().split(",");
            return new Cars(makeCars(carNames));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames(scanner);
        }
    }

    private static List<Car> makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
