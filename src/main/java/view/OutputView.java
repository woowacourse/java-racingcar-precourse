package view;

import java.util.ArrayList;

enum OutputStringEnums {
	DELIMITER(", ");
	private final String value;

	OutputStringEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}

public class OutputView {

	public void noticeNameInput() {
		System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
	}

	public void noticeTurnInput() {
		System.out.print("시도할 회수는 몇회인가요?\n");
	}

	public void viewAfterOneTurn(ArrayList<String> nameInput, ArrayList<Integer> carPositions) {
		for (int index = 0; index < nameInput.size(); index++) {
			System.out.print(nameInput.get(index) + " : ");
			for (int nowPosition = 0; nowPosition < carPositions.get(index); nowPosition++) {
				System.out.print("-");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public void viewWinner(ArrayList<String> winnerNames) {
		System.out.print("최종 우승자 : " + String.join(OutputStringEnums.DELIMITER.getValue(), winnerNames) + "\n");
	}
}
