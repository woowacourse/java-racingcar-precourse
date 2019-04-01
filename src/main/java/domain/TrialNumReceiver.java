package domain;

import java.util.Scanner;

/**
 * 진행 횟수를 입력받는 클래스
 * 
 * @author wschoi8640
 * @version 1.1
 */
public class TrialNumReceiver {

	private static final String msg = "시도할 횟수는 몇회인가요?";
	private static final String errMsg = "자연수를 입력해야 합니다";

	private int trialNum = 0;
	private Scanner sc = null;

	/**
	 * 게임 진행 횟수를 입력 받는 메소드
	 * 
	 * @return 진행 횟수
	 */
	public int readTrialNum() {
		sc = new Scanner(System.in);
		System.out.println(msg);
		trialNum = sc.nextInt();

		checkValid(trialNum);
		return trialNum;
	}

	/**
	 * 진행횟수의 유효성을 확인하는 메소드
	 * 유효성 위반시 입력메소드 호출
	 * 
	 * @param 진행횟수
	 */
	public void checkValid(int trialNum) {
		if (trialNum <= 0) {
			System.out.println(errMsg);
			readTrialNum();		
		}
	}
}
