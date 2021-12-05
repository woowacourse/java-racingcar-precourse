package racingcar;

public class Application {
	public static void main(String[] args) {
		CarList carList = new CarList();
		new Race(carList.getList());
		carList.printWinner();
		// 우승자 출력
	}
}
