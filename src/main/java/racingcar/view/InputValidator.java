package racingcar.view;

public class InputValidator {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String CAR_NAMES_NO_INPUT_ERROR_MESSAGE = "자동차 이름을 입력해주세요.\n";
    private static final String CAR_NAMES_LONGER_THAN_FIVE_CHARACTER_ERROR_MESSAGE = "각 자동차 이름은 5자를 초과할 수 없습니다.\n";
    private static final String CAR_NAMES_INCLUDE_BLANK_BACK_AND_FORTH_ERROR_MESSAGE = "자동차 이름 앞 뒤에 공백이 포함될 수 없습니다.\n";
    private static final String CAR_NAMES_BLANK_NEXT_TO_REST_ERROR_MESSAGE = "쉼표 뒤에는 공백이 아니어야 합니다.\n";
    private static final String TRIAL_NUMBER_NO_INPUT_ERROR_MESSAGE = "시도 횟수는 공백이 아니어야 합니다.\n";
    private static final String TRIAL_NUMBER_NOT_INTEGER_ERROR_MESSAGE = "시도 횟수는 숫자 형식이어야 합니다.\n";

    public static final String SPLIT_REGEX = ",";

    public InputValidator() {}

    public boolean invokeRegardingToCarNames(String input) {
        String[] split = input.split(SPLIT_REGEX);
        return isNoInput(input, CAR_NAMES_NO_INPUT_ERROR_MESSAGE)
                || isLongerThanFiveCharacter(split)
                || isBlankBackAndForth(split)
                || isBlankNextToRest(input);
    }

    public boolean invokeRegardingToTrialNumber(String input) {
        if (isNoInput(input, TRIAL_NUMBER_NO_INPUT_ERROR_MESSAGE)
                || isParsedToInt(input)) {
            return true;
        }
        return false;
    }

    private void fullExceptionMessage(String exception) {
        System.out.print(ERROR_PREFIX + exception);
    }

    private boolean isNoInput(String input, String errorMessage) {
        if (input.length() == 0) {
            fullExceptionMessage(errorMessage);
            return true;
        }
        return false;
    }

    private boolean isLongerThanFiveCharacter(String[] split) {
        for (String s : split) {
            if (s.length() > 5) {
                fullExceptionMessage(CAR_NAMES_LONGER_THAN_FIVE_CHARACTER_ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }

    private boolean isBlankBackAndForth(String[] split) {
        for (String each : split) {
            if (each.substring(0, 1).equals(" ") || each.substring(each.length()-1).equals(" ")) {
                fullExceptionMessage(CAR_NAMES_INCLUDE_BLANK_BACK_AND_FORTH_ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }

    private boolean isBlankNextToRest(String input) {
        String lastString = input.substring(input.length()-1);
        if (lastString.equals(SPLIT_REGEX)) {
            fullExceptionMessage(CAR_NAMES_BLANK_NEXT_TO_REST_ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    private boolean isParsedToInt(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (Exception e) {
            fullExceptionMessage(TRIAL_NUMBER_NOT_INTEGER_ERROR_MESSAGE);
            return true;
        }
    }
}
