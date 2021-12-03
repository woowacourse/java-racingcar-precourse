package constant;

public class Constant {
    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ATTEMP_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String RESULT_MESSAGE = "\n실행 결과";
    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    public static final String ERROR_CAR_NAME_LENGTH = "[ERROR] 자동차 이름은 5자 이하여야 합니다.";
    public static final String ERROR_CAR_NAME_INPUT_ETC = "[ERROR] 옳바르지 않은 입력타입입니다. \"pobi,woni,jun\"와 같은 타입으로 입력해주세요.";
    public static final String ERROR_CAR_NAME_FRONT_BLANK = "[ERROR] 차 이름 앞에 공백이 있습니다. \"pobi,woni,jun\"와 같은 타입으로 입력해주세요.";
    public static final String ERROR_CAR_NAME_DUPLICATE = "[ERROR] 중복된 차 이름이 있습니다.";
    public static final String ERROR_EMPTY_INPUT = "[ERROR] 입력값이 없습니다.";
    public static final String ERROR_INVALID_ATTEMP = "[ERROR] 시도 횟수는 숫자여야 한다.";

    public static final String CAR_NAME_SEPARATOR = ",";
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MIN_RANDOM_NUM = 1;
    public static final int MAX_RANDOM_NUM = 9;
    public static final int FORWARD_STANDARD = 4;
    public static final int INITIAL_VALUE = 0;
}
