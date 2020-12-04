package inpututils;

import java.util.Scanner;

public class InputName extends Input{
	public InputName(Scanner scanner){
		super(scanner);
	}

	@Override
	Scanner getScanner() {
		return super.scanner;
	}

	public String[] inputAnswer() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return splitRest(getScanner().next());
	}

	public String[] splitRest(String answer) {
		return answer.split(",");
	}
}
