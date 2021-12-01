package config;

public class Message {
	private final String ENTER_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private final String ASK_REPEAT_NUM = "시도할 회수는 몇회인가요?";
	private final String PRINT_RESULT = "실행 결과";
	private final String ENTER_WINNER = "최종 우승자 : ";

	public String getENTER_CARS_NAME() {
		return ENTER_CARS_NAME;
	}

	public String getASK_REPEAT_NUM() {
		return ASK_REPEAT_NUM;
	}

	public String getPRINT_RESULT() {
		return PRINT_RESULT;
	}

	public String getENTER_WINNER() {
		return ENTER_WINNER;
	}
}
