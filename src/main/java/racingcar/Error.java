package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Error {

    static final String ERROR_PREFIX = "[ERROR] ";
    static final String SAME_CAR_NAME_ERROR = "자동차 이름이 중복됩니다";
    static final String INVALID_CAR_NAME_LENGTH_ERROR = "자동차 이름은 1자 이상 5자 이하이어야 한다";
    static final String INVALID_TRIAL_NUMBER_ERROR = "1이상의 숫자를 입력하세요";
    static final String INVALID_TRIAL_TYPE_ERROR = "시도 횟수는 숫자여야 한다";
    static final int MAX_CAR_NAME_LENGTH = 5;
    static final int MIN_CAR_NAME_LENGTH = 1;



    public void checkSameCarName(List<String> carNameList) throws IllegalArgumentException{
        Set<String> carNameSet = new HashSet<>(carNameList);
        if(carNameSet.size() < carNameList.size()) {
            System.out.print(ERROR_PREFIX + SAME_CAR_NAME_ERROR);
            throw new IllegalArgumentException();
        }

    }

    public void checkCarNameLength(List<String> carNameList) throws IllegalArgumentException{
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

    public void checkTrialIsInteger(String trial) throws IllegalArgumentException{
        try {
            Integer.parseInt(trial);
        }catch (NumberFormatException e) {
            System.out.println(ERROR_PREFIX + INVALID_TRIAL_TYPE_ERROR);
            throw new IllegalArgumentException();
        }
    }
}
