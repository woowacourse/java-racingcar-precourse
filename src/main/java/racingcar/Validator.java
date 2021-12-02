package racingcar;

import java.util.HashSet;

public class Validator {
    private static final int CAR_NAME_LENGTH = 6;
    private static final int MIN_COIN = 1;

    public void validateCarNamesDuplicate(String[] carNamesArray) {
        HashSet<String> carNameSet = new HashSet<>();
        for (String carName : carNamesArray) {
            carNameSet.add(carName);
        }
        if (carNameSet.size() != carNamesArray.length) {
            throw new IllegalArgumentException(" 중복된 자동차 이름을 입력하였습니다.");
        }
    }

    public void validateCarNamesLength(String[] carNamesArray) {
        for (String carName : carNamesArray) {
            if (carName.length() >= CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(" 자동차 이름은 최대 5자까지 입력 가능합니다.");
            }
        }
    }

    public void validateMoreThanOne(int gameCoin) {
        if (gameCoin < MIN_COIN) {
            throw new IllegalArgumentException(" 1 이상의 정수만 입력 가능합니다.");
        }
    }

    public int validateOnlyInteger(String coin) {
        for (String digit : coin.split("")) {
            if (digit.charAt(0) < '0' || digit.charAt(0) > '9') {
                throw new IllegalArgumentException(" 숫자만 입력이 가능합니다.");
            }
        }
        return Integer.parseInt(coin);
    }
}
