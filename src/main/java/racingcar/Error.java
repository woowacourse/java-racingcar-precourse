package racingcar;

import java.util.List;

public class Error {

    static final String ERROR_PREFIX = "[ERROR] ";
    static final String SAME_CAR_NAME_ERROR = "자동차 이름이 중복됩니다";
    static final String INVALID_CAR_NAME_LENGTH_ERROR = "자동차 이름은 1자 이상 5자 이하이어야 한다";
    static final int MAX_CAR_NAME_LENGTH = 5;
    static final int MIN_CAR_NAME_LENGTH = 1;

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

    public void checkCarNameLength(String inputCars) throws IllegalArgumentException{
        List<String> carNameList = input.getCarNameList(inputCars);
        for (String carName : carNameList) {
            if (carName.length() > MAX_CAR_NAME_LENGTH || carName.length() < MIN_CAR_NAME_LENGTH) {
                System.out.print(ERROR_PREFIX + INVALID_CAR_NAME_LENGTH_ERROR);
                throw new IllegalArgumentException();
            }
        }
    }
}
