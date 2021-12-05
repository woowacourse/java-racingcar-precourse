package racingcar;

public class Validator {

    public void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이가 5를 넘습니다");
        }
    }

    public Integer convertToNumber(String rawRepeatTimes) {
        try {
            return Integer.parseInt(rawRepeatTimes);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    public void validateRepeatTimes(Integer repeatTimes) {
        if (repeatTimes <= 0) {
            throw new IllegalArgumentException("[ERROR] 1 이상의 수를 입력해야 합니다");
        }
    }
}
