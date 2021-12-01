package racingcar;

public class Printer {
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String DASH = "-";

	public static void printProgress(Car[] cars) {
		System.out.println(RESULT_MESSAGE);
		for (Car car : cars) {
			String result = car.getName() + " : ";
			result += buildProgress(car.getPosition());
			System.out.println(result);
		}
		System.out.println();
	}

	private static String buildProgress(int position) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < position; i++) {
			result.append(DASH);
		}
		return result.toString();
	}
}
