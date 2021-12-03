package racingcar.user;

public class Output {
	private static final String DISTANCE = "-";

	private void printDistance(int result) {
		for (int i = 0; i < result; i++) {
			System.out.print(DISTANCE);
		}
	}
}
