package domain;

public class Printer {

	public void printInputCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public void printContainComma() {
		System.out.println("자동차 이름을 쉼표(,)로 구분해 주세요.");
	}

	public void printCarNameLength() {
		System.out.println("자동차 이름을 5자 이하로 입력해 주세요.");
	}

	public void printEmptyCarName() {
		System.out.println("비어있는 자동차 이름이 있습니다. 다시 입력해 주세요.");
	}
}
