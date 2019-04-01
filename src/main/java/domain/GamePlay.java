package domain;

import java.util.ArrayList;

/**
 * 게임 진행 및 진행 상황 출력하는 클래스
 * 
 * @author wschoi8640
 * @version 1.1
 */
public class GamePlay {

	private ArrayList<Car> carList = new ArrayList<>();
	private int carNum = 0;
	private int trialNum = 0;

	/**
	 * 게임 설정을 가져와 게임에 적용하는 메소드
	 * 자동차 객체를 생성하고 리스트에 저장
	 * 
	 * @param gameSetting 정보
	 */
	public void setGameSetting(String[] gameSetting) {
		carNum = gameSetting.length - 1;
		for (int i = 0; i < gameSetting.length - 1; i++) {
			carList.add(new Car(gameSetting[i]));
		}
	}

	/**
	 * 각 자동차가 전진 혹은 정지할지 정하고 움직이는 메소드
	 * 생성해놓은 자동차 객체의 위치를 변경
	 */
	public void race() {
		for (int i = 0; i < carNum; i++) {
			int key = (int) (Math.random() * 9);
			if (key > 3) {
				Car curCar = carList.get(i);
				curCar.move();
			}
		}
		printResult(carList);
		trialNum = trialNum + 1;
	}

	/**
	 * 게임 진행 상황을 출력하는 메소드
	 * 진행상황을 입력받아 진행이 끝날때 마다 실행됨
	 * 
	 * @param 진행상황
	 */
	private void printResult(ArrayList<Car> carList) {
		System.out.println();
		if (trialNum == 0)
			System.out.println("실행 결과");
		for (int i = 0; i < carList.size(); i++) {
			Car curCar = carList.get(i);
			System.out.print(curCar.getName() + " : ");
			for (int j = 0; j < curCar.getPosition(); j++) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
	}

	public ArrayList<Car> getCarList() {
		return carList;
	}
}