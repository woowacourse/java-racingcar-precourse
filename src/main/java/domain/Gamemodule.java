/*
 * @(#)Playgame.java	1.8.0_191 2019/04/02
 * 
 * Copyright (c) 2019 Youngbae Son
 * ComputerScience, ProgrammingLanguage, Java, Busan, KOREA
 * All rights reserved.
 * 
 * */

package domain;

/*
 * 게임을 운영하는 클래스
 * 
 * carlist : 자동차들을 저장하고 있는 리스트
 * inputCarname : 입력받은 자동차 이름
 * inputRound : 입력받은 시도회수
 * winnerPoint : 가장 빠른 위치
 * 
 * 1.initSetup : 게임가이드 메세지 출력
 * 2.inputCarname : 자동차의 이름을 입력 받고, 5자리 이하인지에 대한 예외 처리
 * 3.inputRoundturn : 시도 횟수를 입력 받고, 정수 아닌 값을 예외 처리
 * 4.createCar : 자동차 생성
 * 5.racing : 레이싱
 * 6.checkWinner : 우승자 검사
 * 
 * @author 손영배
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class Gamemodule {

	private ArrayList<Car> carlist;
	private String inputCarname = null;
	private String inputRound = null;
	private int winnerPoint = 0;

	public Gamemodule() {
		carlist = new ArrayList<>();
	}

	public void initSetup() {

		while (!inputCarname());

		while (!inputRoundturn());

		createCar();

	}

	private boolean inputCarname() {

		Scanner scan = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");

		this.inputCarname = scan.nextLine();
		String[] carNameSplit = this.inputCarname.split(",");

		for (int i = 0; i < carNameSplit.length; i++) {
			if (carNameSplit[i].length() < 1 || carNameSplit[i].length() > 5)
				return false;
		}

		return true;
	}

	private boolean inputRoundturn() {

		Scanner scan = new Scanner(System.in);
		System.out.println("시도할 회수는 몇회인가요?");
		this.inputRound = scan.nextLine();
		int num = 0;

		for (int i = 0; i < this.inputRound.length(); i++) {
			try {
				num = Integer.parseInt(inputRound);
			} catch (Exception e) {
				return false;
			}
		}

		return true;
	}

	public void createCar() {

		String[] carNameSplit = this.inputCarname.split(",");

		for (int i = 0; i < carNameSplit.length; i++) {
			this.carlist.add(new Car(carNameSplit[i]));
		}

		System.out.println();
	}

	public void racing() {

		System.out.println("실행결과");

		for (int j = 0; j < carlist.size(); j++) {
			this.carlist.get(j).acceleratorAndbreak();
			this.carlist.get(j).printDistance();
			this.winnerPoint = Math.max(this.winnerPoint, this.carlist.get(j).getPosition());
		}

		System.out.println();
	}

	public void checkWinner() {

		int manyPeople = 0;

		for (int i = 0; i < carlist.size(); i++) {

			if (this.winnerPoint == carlist.get(i).getPosition()) {

				if (manyPeople > 0) {
					System.out.print(",");
				}

				System.out.print(carlist.get(i).getName());
				manyPeople++;
			}
		}

		System.out.println("가 최종 우승했습니다");

	}

	public String getInputCarname() {
		return inputCarname;
	}

	public int getInputRound() {
		return Integer.parseInt(inputRound);
	}
}
