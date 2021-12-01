package racingcar;

public class Constants {
	// 출력 메시지
	static final String INPUT_CAR_NAMES_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	static final String INPUT_PLAY_TIMES_MSG = "시도할 회수는 몇회인가요?";
	static final String RACE_RESULT_MSG = "실행 결과";
	static final String FINAL_WINNERS_MSG = "최종 우승자";

	// [ERROR] 메시지
	static final String ERROR = "[ERROR] ";
	static final String WRONG_CAR_NAMES = "자동차 이름의 길이는 5이하여야 한다.";
	static final String WRONG_PLAY_TIMES = "시도 횟수는 0으로 시작하지 않는 숫자여야 한다.";
	
	// Car().race() 관련 상수
	static final int RACE_DICE_START_INCLUSIVE = 0;
	static final int RACE_DICE_END_INCLUSIVE = 9;
}
