package domain;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputManager {
	private static final int MAX_LENGTH = 5;
	private static final int ZERO = 0;

	/**
	 * 자동차 이름을 입력받는 메서드
	 * 중복된 이름이거나, 이름이 다섯글자 이상이면 재입력 요청
	 */
	public String[] inputCarNames() {
		Scanner input = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
		try{
			String[] carNames = input.next().split(",");
			verifyDuplication(carNames);
			verifyOverLength(carNames);
			return carNames;
		} catch(Exception e){
			System.out.println("잘못된 입력입니다.");
			return inputCarNames();
		}
	}

	private void verifyDuplication(String[] carNames) throws Exception {
		Set<String> set = Arrays.stream(carNames).collect(Collectors.toSet());
		if (set.size() < carNames.length){
			throw new Exception();
		}
	}

	private void verifyOverLength(String[] carNames) throws Exception {
		if (Arrays.stream(carNames).filter(name -> name.length() > MAX_LENGTH) != null){
			throw new Exception();
		}
	}
	
	/**
	 * 시도횟수 입력받는 메서드
	 * 음수, 0, 문자 포함시 재입력 요청
	 */
	public int inputTrialTime() {
		Scanner input = new Scanner(System.in);
		System.out.println("시도할 회수는 몇회인가요?");
		try {
			int trialTime = input.nextInt();
			verifyPositive(trialTime);
			return trialTime;
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			return inputTrialTime();
		}
	}
	
	private void verifyPositive(int trialTime) throws Exception {
		if (trialTime <= ZERO) {
			throw new Exception();
		}
	}
	
}
