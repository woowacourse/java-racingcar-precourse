package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public class Input {
	private static final Pattern NUMBER = Pattern.compile("[0-9]+");
	private static String[] carNames = null;
	private static String input = null;
	private static boolean flag = true;

	public static String[] inputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		while (true) {
			flag = true;
			carNames = readLine().split(",");
			try {
				for (int i = 0; i < carNames.length; i++) {
					String name = carNames[i];
					if (name.length() > 5) {
						flag = false;
						throw new IllegalArgumentException();
					}
				}
			} catch (IllegalArgumentException ex) {
				System.out.println("[ERROR] 이름은 5자 이하만 가능하다.");
			}
			if (flag) {
				break;
			}
		}
		return carNames;
	}

	public static Car[] inputCarNameToCarObj(String[] carNames) {
		Car[] cars = new Car[carNames.length];
		AtomicInteger idx = new AtomicInteger();
		Arrays.stream(carNames).forEach(
			(name) -> cars[idx.getAndIncrement()] = new Car(name)
		);

		return cars;
	}

	public static int inputCoinNumber() {
		System.out.println("시도할 횟수는 몇회인가요?");
		while (true) {
			flag = true;
			input = readLine();
			try {
				if (!NUMBER.matcher(input).matches()) {
					flag = false;
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
			}
			if (flag)
				break;
		}

		return Integer.parseInt(input);
	}
}
