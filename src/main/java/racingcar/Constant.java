package racingcar;

public class Constant {
    public final static String INPUT_DELIMITER = ",";
    public final static String INPUT_DELIMITER_KOREAN = "쉼표";

    public final static String CHECK_NULL_REGEX = "^$|^\\s$";
    public final static String CHECK_PARTIAL_SPACE_REGEX = "^*\\S*$";
    public final static int CHECK_LENGTH = 5;

    public final static String INTEGER_RANGE = "0 이상 2,147,483,647 이하";

    public final static String ERROR_HEADER = "[ERROR] ";
    public final static String ILLEGAL_ARGUMENT_EXCEPTION_NULL = "이름이 공백일 수 없습니다.";
    public final static String ILLEGAL_ARGUMENT_EXCEPTION_PARTIAL_SPACE = "이름 앞, 뒤, 사이에 공백없이 작성해주세요.";
    public final static String ILLEGAL_ARGUMENT_EXCEPTION_LENGTH = "이름은 " + CHECK_LENGTH + "자 이하로 작성해주세요.";
    public final static String ILLEGAL_ARGUMENT_EXCEPTION_DUPLICATE = "중복된 이름이 있습니다.";
    public final static String ILLEGAL_ARGUMENT_EXCEPTION_NOT_INTEGER = "시도 횟수는 "+INTEGER_RANGE+" 범위 내 숫자여야 합니다.";
    public final static String ILLEGAL_ARGUMENT_EXCEPTION_NOT_POSITIVE_INTEGER = "시도 횟수는 양수여야 합니다.";


    public final static String OUTPUT_VIEW_NAME = "경주할 자동차 이름을 입력하세요.(이름은 " + INPUT_DELIMITER_KOREAN
            + "(" + INPUT_DELIMITER + ") 기준으로 구분";
    public final static String OUTPUT_VIEW_REPETITION_COUNT = "시도할 횟수는 몇회인가요?";
}
