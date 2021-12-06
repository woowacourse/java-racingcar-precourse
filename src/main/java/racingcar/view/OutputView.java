package racingcar.view;

public class OutputView {
	public static void printPosition(String carName, int position) {
		System.out.println(carName + " : ");
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
