/**
 * name : Car
 * version : 1.0
 * date : 2019.03.31
 * author : heebong
 * */
package domain;

import java.util.Random;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public int getPosition() {
		return this.position;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 임의의 숫자 생성 전진 상황 출력
	 */
	public void playRacingOneTime() {
		int randNum = makeRandomNum();
		isGoingForwardIncreasePosition(randNum);

		printResultStr();
	}

	/**
	 * 0~9 사이의 임의의 숫자 생성
	 */
	private int makeRandomNum() {
		Random rand = new Random();
		int randNum = rand.nextInt(10);

		return randNum;
	}

	/**
	 * 임의의 숫자가 4 이상이면 전진(true), 3 이하면 정지(false) 전진이면 position 값 +1;
	 */
	private void isGoingForwardIncreasePosition(int randNum) {
		if (randNum >= 4) {
			this.position += 1;
		}
	}

	/**
	 * 출력 형태 : 이름 : -(전진 횟수)
	 */
	private void printResultStr() {
		String strResult = "";
		strResult += this.name + " : ";
		strResult += printForwardingCnt();

		System.out.println(strResult);
	}

	/**
	 * printResultStr에서 사용하는 함수.
	 */
	private String printForwardingCnt() {
		String strResult = "";

		for (int i = 0; i < this.position; i++) {
			strResult += "-";
		}

		return strResult;
	}
}
