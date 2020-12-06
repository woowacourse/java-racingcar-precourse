package racingcar.io;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import racingcar.domain.Car;

public class InputView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String RACING_CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_CAR_NAME_SEPARATOR = ",";
    public static Scanner scanner;

    public static List<Car> getCars() {
        System.out.println(RACING_CAR_NAME_REQUEST_MESSAGE);
        try {
            List<String> carNames = parseCarNameInput(scanner.nextLine());
            List<Car> cars = new LinkedList<>();
            for (int i = 0; i < carNames.size(); i++) {
                cars.add(new Car(carNames.get(i)));
            }
            return cars;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getCars();
        }
    }

    private static List<String> parseCarNameInput(String input) {
        input = input.replaceAll(" ", "");

        List<String> delimitedInputs = Arrays.asList(input.split(RACING_CAR_NAME_SEPARATOR, 0));
        List<String> paredInputs = new LinkedList<>();

        for (String delimitedInput : delimitedInputs) {
            if (delimitedInput.length() == 0) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 쉼표(,)를 기준으로 구분되어야합니다.");
            } else if (delimitedInput.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야합니다.");
            }
            paredInputs.add(delimitedInput);
        }
        return paredInputs;
    }

}
