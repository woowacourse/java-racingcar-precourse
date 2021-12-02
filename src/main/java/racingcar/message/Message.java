package racingcar.message;

public enum Message {
	ENTER_CARS_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	ASK_REPEAT_NUM("시도할 회수는 몇회인가요?"),
	PRINT_RESULT("실행 결과"),
	ENTER_WINNER("최종 우승자 : ");

	private String message;

	Message(String errorMessage){
		this.message = errorMessage;
	}

	public String getMessage(){
		return message;
	}
}
