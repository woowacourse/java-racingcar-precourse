package racingcar.type;

public enum TextType {
	ERROR("[ERROR] %s"),
	RESULT("%n실행 결과"),
	WINNER("최종 우승자 %s %s"),
	CAR_STATUS("%s %s %s"),
	CAR_NAME_REQUEST("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	TRY_NUMBER_REQUEST("시도할 회수는 몇회인가요?");

	private final String text;

	TextType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
