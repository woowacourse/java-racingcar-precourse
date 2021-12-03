package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarGame {
    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_CAR_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 1자 이상, 5자 이하로 작성해야 합니다.";
    public ArrayList<Car> cars;

    public void start() {
        inputCarName();
    }

    public void inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String input = Console.readLine();
        String[] carNames = input.split(",");

        cars = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(name -> cars.add(new Car(name)));
        validateCarName(cars);
    }

    public void validateCarName(ArrayList<Car> carNames) {
        try {
            for (Car carName : carNames) {
                carName.isNameNull(carName.getName());
                carName.isNameOutOfRange(carName.getName());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_CAR_NAME_ERROR_MESSAGE);
            inputCarName();
        }
    }
}

