package domain;

import java.util.Scanner;

public class InputManager {

	private int trialTime;
	private String[] carNames;

	public void initialize() {
		inputCarNames();
	}
	
	private void inputCarNames() {
		Scanner input = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
		carNames = input.next().split(",");
	}
	
}
