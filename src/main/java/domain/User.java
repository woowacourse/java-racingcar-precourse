package domain;

import java.util.InputMismatchException; //예외처리위해 필요.
import java.util.Scanner;

//공백들어간경우 어떻게 처리되는 것지 이해를 못하겠다.
//중복id경우?
public class User {
	private static String[] carNames;
	private static int trialNum;
	
	private static void setCarNames() {
		Scanner input = new Scanner(System.in);
		System.out.println("경주에 참여할 자동차들의 이름을 입력하세요.");
		System.out.println("조건: 각 차량은 콤마(,)로 구분하며 "
				+ "차량이름은 5글자 이하로 한다.");
		String tmp = input.next();
		User.carNames = tmp.split(",");
		//input.close();
	}
	
	static void setValidCarNames() {
		while (true) {
			User.setCarNames();
			try {
				setValidCarNamesIf();
				break;
			} catch (Exception ime) {
				System.out.println("잘못된 입력: "
						+ "각 자동차의 id는 5글자 이하여야합니다.");
			}
		}
		System.out.println("사용자 입력이 정상적으로 입력되었습니다.");
	}

	private static void setValidCarNamesIf() throws Exception {
		for (int i = 0; i < User.carNames.length; i++) {
			if (User.carNames[i].length() > 5) {
				throw new Exception();
			}
		}
	}
	
	public static String[] getCarNames() {
		return User.carNames;
	}
	
	private static void setTrialNum() throws Exception {
		Scanner input2 = new Scanner(System.in);
		System.out.println("경주할 횟수를 입력하세요.");
		trialNum = input2.nextInt();
		// 정수아닌 자료 입력시 ImputMismatchException예외 출력
		// 자연수 아닌 자료 입력시 아래 if문에서 Exception예외 출력
		if (trialNum <= 0) {
			Exception ex1 = new Exception();
			throw ex1;
		}
	}
	
	public static void setValidTrialNum() {
		while (true) {
			try {
				User.setTrialNum();
				break;				
			} catch (InputMismatchException ime) {
				System.out.println("잘못된 입력: 정수를 입력하세요.");
			} catch (Exception ex1) {
				System.out.println("잘못된 입력: 양수를 입력하세요.");
			}
		}
		System.out.println("사용자 입력 : "+ trialNum 
				+ "이(가) 정상적으로 입력되었습니다." );
	}
	
	public static int getTrialNum() {
		return User.trialNum;
	}
	
	public static void main(String[] args) throws Exception{
		//User test
//		getValidCarName();
//		for (int i = 0; i < carNames.length; i++) {
//			System.out.println(carNames[i]);
//		}
		
		//trialNum() test
		setValidTrialNum();
		System.out.println(trialNum);
	}
}
