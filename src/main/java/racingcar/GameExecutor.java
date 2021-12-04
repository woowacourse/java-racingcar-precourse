package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameExecutor {

    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public GameExecutor() {}

    private List<String> getCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String[] carNames = Console.readLine().trim().split(",");

        return new ArrayList<>(Arrays.asList(carNames));
    }

    public List<Car> createCars() {
        List<String> carNameList = getCarNames();
        List<Car> carList = new ArrayList<>();

        for (String name : carNameList) {
            carList.add(new Car(name));
        }

        return carList;
    }

    public int getCount() {
        String inputCount;

        System.out.println(INPUT_COUNT_MESSAGE);
        inputCount = Console.readLine().trim();
        Validator.validateCountInputFormat(inputCount);

        return Integer.parseInt(inputCount);
    }
}
