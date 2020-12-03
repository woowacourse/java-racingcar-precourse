package racingcar;

import java.util.List;
import java.util.Scanner;

public class Error {

    static final String ERROR_PREFIX = "[ERROR] ";
    static final String SAME_CAR_NAME_ERROR = "자동차 이름이 중복됩니다";
    static final String INVALID_CAR_NAME_LENGTH_ERROR = "자동차 이름은 1자 이상 5자 이하이어야 한다";
    static final String INVALID_TRIAL_NUMBER_ERROR = "1이상의 숫자를 입력하세요";
    static final String INVALID_TRIAL_TYPE_ERROR = "시도 횟수는 숫자여야 한다";
    static final int MAX_CAR_NAME_LENGTH = 5;
    static final int MIN_CAR_NAME_LENGTH = 1;

    Input input = new Input();

    public void checkSameCarName(String[] carNameArray) throws IllegalArgumentException{
        List<String> carNameList = input.getCarNameList(carNameArray);
        for (String carName : carNameList) {
            if(carNameList.contains(carName)) {
                System.out.print(ERROR_PREFIX + SAME_CAR_NAME_ERROR);
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkCarNameLength(String[] carNameArray) throws IllegalArgumentException{
        List<String> carNameList = input.getCarNameList(carNameArray);
        for (String carName : carNameList) {
            if (carName.length() > MAX_CAR_NAME_LENGTH || carName.length() < MIN_CAR_NAME_LENGTH) {
                System.out.print(ERROR_PREFIX + INVALID_CAR_NAME_LENGTH_ERROR);
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkTrialLessThanOne(int trial) throws IllegalArgumentException{
        if (trial < 1) {
            System.out.println(ERROR_PREFIX + INVALID_TRIAL_NUMBER_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public void trialNotIntegerError() {
        System.out.println(ERROR_PREFIX + INVALID_TRIAL_TYPE_ERROR);
    }


}
