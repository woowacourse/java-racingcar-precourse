package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameExecutor {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().trim().split(",");

        return new ArrayList<>(Arrays.asList(carNames));
    }

    public List<Car> createCars(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();

        for (String name : carNameList) {
            carList.add(new Car(name));
        }

        return carList;
    }
}
