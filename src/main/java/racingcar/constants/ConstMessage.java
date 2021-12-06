package racingcar.constants;

public class ConstMessage {
    //입력 요청
    public static final String NAMES_INPUT_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ROUND_NUMBER_INPUT_REQUEST = "시도할 회수는 몇회인가요?";
    public static final String CORRECT_ROUND_INPUT_REQUEST = "0이상의 정수를 입력해주세요.";

    //게임 정보
    public static final String PLAY_RESULT_MESSAGE = "\n실행 결과";
    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    public static final String NAME_POSITION_DELIMITER = " : ";
    public static final String NAME_AND_NAME_DELIMITER = ", ";
    public static final String NAME_PARSING_DELIMITER = ",";

    //에러 메시지
    public static final String NAME_INPUT_ERROR = "[ERROR]: 모든 이름은 " + ConstValue.NAME_LENGTH_LIMIT + " 이하의 문자로 입력해주세요.";
    public static final String SAME_NAME_ERROR = "[ERROR]: 동일한 이름이 입력됨: ";
    public static final String EMPTY_NAME_ERROR = "[ERROR]: 빈 이름이 입력되었습니다.";
    public static final String NOT_INTEGER_INPUT_ERROR = "[ERROR]: 정수가 아닌 값이 입력되었습니다. ";
    public static final String NEGATIVE_INPUT_ERROR = "[ERROR]: 음수가 입력되었습니다. ";
}
