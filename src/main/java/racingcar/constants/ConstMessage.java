package racingcar.constants;

public class ConstMessage {
    //입력 요청
    public static final String NAMES_INPUT_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ROUND_NUMBER_INPUT_REQUEST = "시도할 회수는 몇회인가요?";

    //게임 정보
    public static final String PLAY_RESULT_MESSAGE = "\n실행 결과";
    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    public static final String NAME_POSITION_DELIMITER = " : ";
    public static final String NAME_AND_NAME_DELIMITER = ", ";
    public static final String NAME_PARSING_DELIMITER = ",";

    //에러 메시지
    public static final String NAME_INPUT_ERROR = "[ERROR]: 모든 이름은 %d 이하의 문자로 입력해주세요.\n";
    public static final String ROUND_INPUT_ERROR = "[ERROR]: 시도 횟수는 0이상의 정수로 입력해주세요.";
}
