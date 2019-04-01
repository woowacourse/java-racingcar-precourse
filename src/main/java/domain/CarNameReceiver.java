package domain;

import java.util.Scanner;

/**
 * 자동차들의 이름들을 입력받는 클래스
 * 
 * @author wschoi8640
 * @version 1.0
 */
public class CarNameReceiver {

	private static final String msg = "경주할 자동차 이름을 입력하세요. (이름은 쉼표 (,)로 구분)";
	private static final String errMsg = "자동차 이름은 5자 이하로 입력해야 합니다.";
	private Scanner sc = null;
	private String carNames = "";
	private String[] carNameArr = null;
	private boolean isValid = false;

	
	/**
	 * 차 이름을 한꺼번에 입력 받는 메소드
	 * 
	 * @return 차 이름 배열
	 */
	public String[] readCarNames() {
		sc = new Scanner(System.in);
		System.out.println(msg);
		carNames = sc.nextLine();

		return namesToArr(carNames);
	}

	/**
	 * 문자열을 잘라 배열로 만드는 메소드
	 * 
	 * @param 입력받은 차 이름 문자열
	 * @return 차 이름 배열
	 */
	public String[] namesToArr(String carNames) {
		carNameArr = carNames.split(",");
		checkValid(carNameArr);
		
		return carNameArr;
	}

	/**
	 * 차 이름의 유효성을 확인하는 메소드
	 * 유효성 위반시 입력메소드 호출
	 * 
	 * @param 차 이름 배열
	 */
	public void checkValid(String[] carNameArr) {
		isValid = true;
		for (String carName : carNameArr) {
			if ((carName.length() > 5) || carName.equals("")) {
				isValid = false;
				break;
			}
		}
		if (!isValid) {
			System.out.println(errMsg);
			readCarNames();
		}
	}

}
