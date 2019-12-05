package domain;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputManager {

	private int trialTime;
	private String[] carNames;

	public void initialize() {
		inputCarNames();
		inputTrialTime();
	}

	private void inputCarNames() {
		Scanner input = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
		carNames = input.next().split(",");

		while (isDuplicated(carNames) | isOverLength(carNames)) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
			carNames = input.next().split(",");
		}
	}

	private boolean isDuplicated(String[] carNames) {
		Set<String> set = Arrays.stream(carNames).collect(Collectors.toSet());
		return set.size() < carNames.length;
	}

	private boolean isOverLength(String[] carNames) {
		for (String name : carNames) {
			if (name.length() > 5) {
				return true;
			}
		}
		return false;
	}
	
	private void inputTrialTime() {
		Scanner input = new Scanner(System.in);
		System.out.println("시도할 회수는 몇회인가요?");
		while (true) {
			try {
				trialTime = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요.");
			} catch (Exception e) {
			} finally {
				System.out.println("시도할 회수는 몇회인가요?");
				input = new Scanner(System.in);
			}
		}
	}
}
