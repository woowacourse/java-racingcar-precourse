/**
 * @(#)User.java
 * 0.0.0
 * 2019/12/10
 */

package domain;

import java.util.Scanner;
import java.util.InputMismatchException; //예외처리위해 필요.

/**
 * 사용자로부터 입력을 받아오는 기능을 위한 클래스
 * 
 * @version 0.0.0 2019년 12월 10일
 * @author tiroring
 */
public class User {
	/** 차량이름길이제한 */
	private static final int CONDITION = 5;
	private String[] carNames;
	private int trialNumber;

	/** 클래스 생성자. 인스턴스를 생성하면서 사용자로부터 입력을 받는다. */
	public User() {
		System.out.println("(1) 경주에 참여할 자동차들의 이름을 "
				+ "입력하세요.\n조건: 각 차량은 콤마(,)로 구분하며 "
				+ "차량이름은 5글자 이하로 한다.");
		this.setCarNames();
		System.out.println("(2) 경주할 횟수를 입력하세요.");
		this.setTrialNumber();
	}

	/** 사용자로부터 차량정보를 입력받고, 유효성을 검사한다. */
	private void setCarNames() {
		Scanner input = new Scanner(System.in);
		this.carNames = input.next().split(",");
		try {
			this.isCarNameValid();
			System.out.println("차량이름이 정상적으로 입력되었습니다.\n");
		} catch (Exception ime) {
			System.out.println("잘못된 입력: "
					+ "각 자동차의 이름은 5글자 이하여야합니다.");
			this.setCarNames(); // 오류시 재귀
		}
	}

	/** setCarNames내부에서 차량이름을 순회하고, 조건보다 길면 예외발생. */
	private void isCarNameValid() throws Exception {
		for (int i = 0; i < this.carNames.length; i++) {
			if (this.carNames[i].length() > CONDITION) {
				throw new Exception();
			}
		}
	}

	public String[] getCarNames() {
		return this.carNames;
	}

	/** 사용자로부터 시도횟수를 입력받고 유효성을 검사한다. */
	private void setTrialNumber() {
		try {
			Scanner input = new Scanner(System.in);
			this.trialNumber = input.nextInt();
			if (this.trialNumber <= 0) {throw new Exception();}
			System.out.println("사용자 입력: "
					+ this.trialNumber + "\n");
		} catch (InputMismatchException ime) {
			System.out.println("잘못된 입력: 정수를 입력하세요.");
			this.setTrialNumber(); // 오류시 재귀
		} catch (Exception e) {
			System.out.println("잘못된 입력: 양수를 입력하세요.");
			this.setTrialNumber(); // 오류시 재귀
		}
	}

	public int getTrialNumber() {
		return this.trialNumber;
	}
}
