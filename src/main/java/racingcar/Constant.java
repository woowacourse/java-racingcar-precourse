package racingcar;

public class Constant {
    public final static String INPUT_DELIMITER = ",";

    public final static String CHECK_NULL_REGEX = "^$|^\\s$";
    public final static String CHECK_PARTIAL_SPACE_REGEX = "^*\\S*$";
    public final static int CHECK_LENGTH = 5;

    public final static String ERROR_HEADER = "[ERROR] ";
    public final static String ILLEGAL_ARGUMENT_EXCEPTION_NULL = "이름이 공백일 수 없습니다.";
    public final static String ILLEGAL_ARGUMENT_EXCEPTION_PARTIAL_SPACE = "이름 앞, 뒤, 사이에 공백없이 작성해주세요.";
    public final static String ILLEGAL_ARGUMENT_EXCEPTION_LENGTH = "이름은 "+CHECK_LENGTH+"자 이하로 작성해주세요.";
    public final static String ILLEGAL_ARGUMENT_EXCEPTION_DUPLICATE = "중복된 이름이 있습니다.";
}
