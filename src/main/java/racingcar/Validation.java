package racingcar;

public class Validation implements IValidation {
    private final String INPUT_LENGTH_ERROR = "[ERROR] 5자 이하의 이름을 입력해주세요.";
    private final String INPUT_NUMBER_ERROR = "[ERROR] 숫자를 입력해주세요.";
    private final String INPUT_RANGE_ERROR = "[ERROR] 0 이상의 값을 입력해주세요.";
    private final String INPUT_BLANK_ERROR = "[ERROR] 이름에는 공백이 포함될 수 없습니다.";
    private final int NAME_MAX_LENGTH = 5;

    @Override
    public void validateLength(String inputList) {
        for (String s : inputList.split(",")) {
            if (s.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(INPUT_LENGTH_ERROR);
            }
        }
    }

    @Override
    public void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR);
        }
    }

    @Override
    public void validateRange(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(INPUT_RANGE_ERROR);
        }
    }

    @Override
    public void validateName(String input) {
        String noSpaces = input.replaceAll(" ", "");
        for (String s : noSpaces.split(",", -1)) {
            if (s.equals("")) {
                throw new IllegalArgumentException(INPUT_BLANK_ERROR);
            }
        }
    }
}
