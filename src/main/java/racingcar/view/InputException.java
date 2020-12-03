package racingcar.view;

public class InputException {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String CAR_NAMES_NO_INPUT_ERROR_MESSAGE = "자동차 이름을 입력해주세요.\n";
    private static final String CAR_NAMES_LONGER_THAN_FIVE_CHARACTER_ERROR_MESSAGE = "각 자동차 이름은 5자를 초과할 수 없습니다.\n";
    private static final String CAR_NAMES_INCLUDE_BLANK_BACK_AND_FORTH_ERROR_MESSAGE = "자동차 이름 앞 뒤에 공백이 포함될 수 없습니다.\n";
    private static final String CAR_NAMES_BLANK_NEXT_TO_REST_ERROR_MESSAGE = "쉼표 뒤에는 공백이 아니어야 합니다.\n";
    private static final String TRIAL_NUMBER_NO_INPUT_ERROR_MESSAGE = "시도 횟수는 공백이 아니어야 합니다.\n";
    private static final String TRIAL_NUMBER_NOT_INTEGER_ERROR_MESSAGE = "시도 횟수는 숫자 형식이어야 합니다.\n";

    public static final String SPLIT_REGEX = ",";

    public InputException() {}

    public boolean invokeRegardingToCarNames(String input) {
        String[] split = input.split(SPLIT_REGEX);
        if (noInputException(input, CAR_NAMES_NO_INPUT_ERROR_MESSAGE)
                || longerThanFiveCharacterException(split)
                || includeBlankBackAndForthException(split)
                || blankNextToRestException(input)
        ) {
            return true;
        }
        return false;
    }

    public boolean invokeRegardingToTrialNumber(String input) {
        if (noInputException(input, TRIAL_NUMBER_NO_INPUT_ERROR_MESSAGE)
                || parseToIntException(input)) {
            return true;
        }
        return false;
    }

    private void fullExceptionMessage(String exception) {
        System.out.print(ERROR_PREFIX + exception);
    }

    private boolean noInputException(String input, String errorMessage) {
        if (input.length() == 0) {
            fullExceptionMessage(errorMessage);
            return true;
        }
        return false;
    }

    private boolean longerThanFiveCharacterException(String[] split) {
        for (String s : split) {
            if (s.length() > 5) {
                fullExceptionMessage(CAR_NAMES_LONGER_THAN_FIVE_CHARACTER_ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }

    private boolean includeBlankBackAndForthException(String[] split) {
        for (String s : split) {
            if (s.substring(0, 1).equals(" ") || s.substring(s.length()-1).equals(" ")) {
                fullExceptionMessage(CAR_NAMES_INCLUDE_BLANK_BACK_AND_FORTH_ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }

    private boolean blankNextToRestException(String input) {
        if (input.substring(input.length()-1).equals(SPLIT_REGEX)) {
            fullExceptionMessage(CAR_NAMES_BLANK_NEXT_TO_REST_ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    private boolean parseToIntException(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (Exception e) {
            fullExceptionMessage(TRIAL_NUMBER_NOT_INTEGER_ERROR_MESSAGE);
            return true;
        }
    }
}
