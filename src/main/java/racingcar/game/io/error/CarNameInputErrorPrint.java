package racingcar.game.io.error;

public class CarNameInputErrorPrint {
    public static final String MORE_THAN_ONE_CAR_NAME_ERROR_MESSAGE
        = "[ERROR] 자동차 이름은 두 개 이상이어야 합니다.";
    public static final String COMMA_ERROR_MESSAGE
        = "[ERROR] 잘못된 쉼표(,) 입력입니다.";
    public static final String CHAR_ERROR_MESSAGE
        = "[ERROR] 자동차 이름은 한글 또는 영어만 가능합니다.";
    public static final String CAR_NAME_LENGTH_ERROR
        = "[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.";
    public static final String NUMBER_OF_CAR_MORE_THAN_MAX_ERROR_MESSAGE
        = "[ERROR] 경주할 자동차 수는 100대 이하여야 합니다.";
    private static final String DUPLICATE_NAME_ERROR_MESSAGE
        = "[ERROR] 중복된 이름이 있습니다.";

    public static void printMoreThanOneCarNameErrorMessage() {
        System.out.println(MORE_THAN_ONE_CAR_NAME_ERROR_MESSAGE);
    }

    public static void printCommaErrorMessage() {
        System.out.println(COMMA_ERROR_MESSAGE);
    }

    public static void printCharErrorMessage() {
        System.out.println(CHAR_ERROR_MESSAGE);
    }

    public static void printCarNameLengthErrorMessage() {
        System.out.println(CAR_NAME_LENGTH_ERROR);
    }

    public static void printNumberOfCarMoreThan100ErrorMessage() {
        System.out.println(NUMBER_OF_CAR_MORE_THAN_MAX_ERROR_MESSAGE);
    }

    public static void printDuplicateNameErrorMessage() {
        System.out.println(DUPLICATE_NAME_ERROR_MESSAGE);
    }
}
