package racingcar;

import java.util.List;

public class Error {

    static final String ERROR_PREFIX = "[ERROR] ";
    static final String SAME_CAR_NAME_ERROR = "자동차 이름이 중복됩니다";

    Input input = new Input();

    public void checkSameCarName(String inputCars) throws IllegalArgumentException{
        List<String> carNameList = input.getCarNameList(inputCars);
        for (String carName : carNameList) {
            if(carNameList.contains(carName)) {
                System.out.print(ERROR_PREFIX + SAME_CAR_NAME_ERROR);
                throw new IllegalArgumentException();
            }
        }
    }
}
