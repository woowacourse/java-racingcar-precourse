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
 * 
 * main : 1-> 2-> 3-> 4 운영
 * 
 * 1.initSetup : 게임가이드 메세지 출력, 자동차 정보 입력, 시도회수 입력
 * 2.createCar : 자동차 생성
 * 3.racing : 레이싱
 * 4.checkWinner : 우승자 검사
 * 
 * 
 * @author 손영배
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class Playgame {

	public static void main(String[] args) {

		ArrayList<Car> carlist = new ArrayList<>();

		int winnerPoint = 0;
		int gameRound = initSetup(carlist);

		for (int i = 0; i < gameRound; i++) {
			winnerPoint = racing(carlist);
		}

		checkWinner(carlist, winnerPoint);

	}

	private static int initSetup(ArrayList<Car> carlist) {

		Scanner scan = new Scanner(System.in);

		String inputCarname = null;
		int inputRound = 0;

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
		inputCarname = scan.nextLine();

		createCar(inputCarname, carlist);

		System.out.println("시도할 회수는 몇회인가요?");
		inputRound = scan.nextInt();
		System.out.println();

		return inputRound;
	}

	private static void createCar(String input, ArrayList<Car> carlist) {

		String[] carNameSplit = input.split(",");

		for (int i = 0; i < carNameSplit.length; i++) {
			carlist.add(new Car(carNameSplit[i]));
		}

	}

	private static int racing(ArrayList<Car> carlist) {

		int MAX = 0;

		System.out.println("실행결과");

		for (int j = 0; j < carlist.size(); j++) {
			carlist.get(j).acceleratorAndbreak();
			carlist.get(j).printDistance();
			MAX = Math.max(MAX, carlist.get(j).getPosition());
		}

		System.out.println();

		return MAX;

	}

	private static void checkWinner(ArrayList<Car> carlist, int winnerPoint) {

		int manyPeople = 0;

		for (int i = 0; i < carlist.size(); i++) {

			if (winnerPoint == carlist.get(i).getPosition()) {

				if (manyPeople > 0) {
					System.out.print(",");
				}

				System.out.print(carlist.get(i).getName());
				manyPeople++;
			}
		}

		System.out.println("가 최종 우승했습니다");

	}

}
