package racingcar;

public class Constant {
    public final static String INPUT_DELIMITER = ",";

    public final static String CHECK_NULL_REGEX = "^$|^\\s$";
    public final static String CHECK_PARTIAL_SPACE_REGEX = "^*\\S*$";

    public final static String ERROR_HEADER = "[ERROR] ";
    public final static String ILLEGAL_ARGUMENT_EXCEPTION_NULL = "이름이 공백일 수 없습니다.";
    public final static String ILLEGAL_ARGUMENT_EXCEPTION_PARTIAL_SPACE = "이름 앞, 뒤, 사이에 공백없이 작성해주세요.";
}
