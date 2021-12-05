package racingcar;

public class Validation {
    private final String INPUT_LENGTH_ERROR = "[ERROR] 5자 이하의 이름을 입력해주세요.";
    private final String INPUT_NUMBER_ERROR = "[ERROR] 숫자를 입력해주세요.";
    private final String INPUT_RANGE_ERROR = "[ERROR] 0 이상의 값을 입력해주세요.";
    private final String INPUT_BLANK_ERROR = "[ERROR] 이름에는 공백이 포함될 수 없습니다.";

    public void validateLength(String inputList) {
        for (String s : inputList.split(",")) {
            if (s.length() > 5) {
                throw new IllegalArgumentException(INPUT_LENGTH_ERROR);
            }
        }
    }

    public void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR);
        }
    }

    public void validateRange(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(INPUT_RANGE_ERROR);
        }
    }

    public void validateName(String input) {
        if (input.lastIndexOf(",") == input.length() - 1) {
            throw new IllegalArgumentException(INPUT_BLANK_ERROR);
        }
        for (String s : input.replaceAll(" ", "").split(",")) {
            if (s.equals("")) {
                throw new IllegalArgumentException(INPUT_BLANK_ERROR);
            }
        }
    }
}
