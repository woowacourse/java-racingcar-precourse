package racingcar;

import java.util.*;

public class Input {

    static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String INPUT_TRIAL_MESSAGE = "시도할 회수는 몇회인가요?";


    public String[] getCarNameArray(Scanner scanner) {
        System.out.println(INPUT_NAME_MESSAGE);
        String inputCars = scanner.next();
        String[] carNames = inputCars.split(",");
        return carNames;
    }

    public List<String> getCarNameList(Scanner scanner) {
        String[] carNameArray = getCarNameArray(scanner);
        List<String> carNameList = new ArrayList<>(carNameArray.length);
        for (String carName : carNameArray) {
            carNameList.add(carName);
        }
        return carNameList;
    }

    public String getTrial(Scanner scanner) {
        System.out.println(INPUT_TRIAL_MESSAGE);
        String trial = scanner.next();
        return trial;
    }
}
