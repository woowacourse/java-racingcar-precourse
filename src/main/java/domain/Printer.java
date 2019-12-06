package domain;

import java.util.ArrayList;


/**
 * 게임에 관련된 모든 콘솔 출력을 담당하는 클래스.
 * @author giantim
 */
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
	
	/**
	 * 시도 횟수 한번 당 자동차들의 정보를 출력한다.
	 * 자동차의 정보는 자동차의 이름과 위치이다.
	 * @param list 모든 자동차의 리스트
	 */
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
	
	/**
	 * 우승자를 출력할 때 게임 시도 횟수와 위치가 같은 자동차만
	 * 먼저 추려낸 후 출력한다.
	 * @param list 모든 자동차 리스트
	 */
	public void printWinner(ArrayList<Car> list) {
		ArrayList<String> prizeList = makePrizeList(list);

		System.out.print(prizeList.get(0));
		for (int i = 1; i < prizeList.size(); i++) {
			System.out.print(Constant.COMMA_WITH_SPACE);
			System.out.print(prizeList.get(i));
		}
		System.out.println("가 최종 우승했습니다.");
	}
	
	/**
	 * 게임 시도 횟수와 위치가 같은 자동차만 추려낸다.
	 * @param list 모든 자동차 리스트
	 * @return 게임 시도 횟수와 위치가 같은 자동차 리스트
	 */
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
