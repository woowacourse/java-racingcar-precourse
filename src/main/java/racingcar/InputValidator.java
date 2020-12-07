package racingcar;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    static final int CAR_NAME_SIZE_CONDITION = 5;

    public boolean validateCarName(String[] cars) {
        if (!isNameSizeValid(cars)) {
            return false;
        }
        if (!isNameDistinct(cars)){
            return false;
        }
        return true;
    }

    public boolean validGameCntInput(String cntInput) {
        for (int i = 0; i < cntInput.length(); i++) {
            if (!Character.isDigit(cntInput.charAt(i))) {
                System.out.println("[ERROR] 시도횟수는 숫자여야 한다.");
                return false;
            }
        }
        return true;
    }

    private boolean isNameSizeValid(String[] cars) {
        for (String carName : cars) {
            if (carName.length() > CAR_NAME_SIZE_CONDITION) {
                System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
                return false;
            }
        }
        return true;
    }

    private boolean isNameDistinct(String[] cars) {
        Set set = new HashSet();
        for (String carName : cars) {
            if(set.contains(carName)) {
                System.out.println("[ERROR] 중복된 자동차 이름이 입력되었습니다.");
                return false;
            }
            set.add(carName);
        }
        return true;
    }
}
