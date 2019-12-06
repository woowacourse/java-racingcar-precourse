package domain;

import java.util.ArrayList;

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

	public void printGameCount() {
		System.out.println("시도할 횟수는 몇회인가요?");
	}

	public void printInputNumber() {
		System.out.println("숫자를 입력해 주세요");
	}

	public void printPlayResult() {
		System.out.println("\r\n실행 결과");
	}

	public void printCarInfomation(ArrayList<Car> list) {
		for (Car c : list) {
			System.out.print(c.getName() + Constant.COLON);
			printCarPosition(c.getPosition());
		}
		System.out.println();
	}

	private void printCarPosition(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print(Constant.BAR);
		}
		System.out.println();
	}

	public void printWinner(ArrayList<Car> list) {
		ArrayList<String> prizeList = makePrizeList(list);
		
		System.out.print(prizeList.get(0));
		for (int i = 1; i < prizeList.size(); i++) {
			System.out.print(Constant.COMMA_WITH_SPACE);
			System.out.print(prizeList.get(i));
		}
		System.out.println("가 최종 우승했습니다.");
	}

	private ArrayList<String> makePrizeList(ArrayList<Car> list) {
		ArrayList<String> prizeList = new ArrayList<String>();
		
		for (Car c : list) {
			if (c.getPrize()) {
				prizeList.add(c.getName());
			}
		}
		return prizeList;
	}
}
