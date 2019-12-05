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

	/*
	 * 자동차 이름을 입력받는 메서드
	 * 중복된 이름이거나, 이름이 다섯글자 이상이면 재입력 요청
	 * 쉼표(,)기준으로 나눠서 배열에 저장
	 */
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
	
	/*
	 * 시도횟수 입력받는 메서드
	 * 음수, 0, 문자 포함시 재입력 요청
	 */
	private void inputTrialTime() {
		Scanner input = new Scanner(System.in);
		System.out.println("시도할 회수는 몇회인가요?");
		while (true) {
			try {
				trialTime = input.nextInt();
				createException(trialTime);
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요.");
			} catch (Exception e) {
				System.out.println("양의 정수를 입력해주세요.");
			} finally {
				System.out.println("시도할 회수는 몇회인가요?");
				input = new Scanner(System.in);
			}
		}
	}
	
	private void createException(int trialTime) throws Exception {
		if (trialTime <= 0) {
			throw new Exception();
		}
	}
	
	public int getTrialTime() {
		return trialTime;
	}

	public String[] getCarNames() {
		return carNames;
	}
	
}
