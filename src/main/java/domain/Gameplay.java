/*
 * @(#)Gameplay.java             1.0.0 2019/04/04
 *
 * Copyright (c) 2019 Kris Kim.
 * ComputerScience, ProgrammingLanguage, Java, Seoul, KOREA
 * All right reserved
 *
 * This software is the confidential and proprietary information of Kris
 * Kim ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Kris Kim
 */

package domain;

/*
 * 게임을 진행하는데 필요한 함수들을 가지고 있는 클래스
 *
 * carList : car객체들을 저장하고 있는 리스트
 * carName : 입력받은 자동차 이름
 * roundNum : 입력받은 시도회수
 * winnerPoint : 가장 빠른 위치
 *
 * 1.initSetup : 게임가이드 메세지 출력
 * 2.setCarName : 자동차의 이름을 입력 받고, 5자리 이하인지에 대한 예외 처리
 * 3.setRoundNum : 시도 횟수를 입력 받고, 정수 아닌 값을 예외 처리
 * 4.createCar : 자동차를 생성하는 함수
 * 5.racing : 레이싱을 진행하는 함수
 * 6.checkWinner : 우승자 검사
 *
 * @author Kris Kim
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class Gameplay {

    private ArrayList<Car> carList;
    private String carName = null;
    private String roundNum = null;
    private int winnerPoint = 0;

    public Gameplay() {
        carList = new ArrayList<>();
    }

    public void initSetup() {

        while (!setCarName()) ;

        while (!setRoundNum()) ;

        createCar();

    }

    private boolean setCarName() {

        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");

        this.carName = scan.nextLine();
        String[] carNameSplit = this.carName.split(",");

        for (int i = 0; i < carNameSplit.length; i++) {
            if (carNameSplit[i].length() < 1 || carNameSplit[i].length() > 5)
                return false;
        }

        return true;
    }

    private boolean setRoundNum() {

        Scanner scan = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        this.roundNum = scan.nextLine();
        int num = 0;

        for (int i = 0; i < this.roundNum.length(); i++) {
            try {
                num = Integer.parseInt(roundNum);
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    public void createCar() {

        String[] carNameSplit = this.carName.split(",");

        for (int i = 0; i < carNameSplit.length; i++) {
            this.carList.add(new Car(carNameSplit[i]));
        }

        System.out.println();
    }

    public void doRace() {

        System.out.println("실행결과");

        for (int j = 0; j < carList.size(); j++) {
            this.carList.get(j).goAndStop();
            this.carList.get(j).printDistance();
            this.winnerPoint = Math.max(this.winnerPoint, this.carList.get(j).getPosition());
        }

        System.out.println();
    }

    public void checkWinner() {

        int manyPeople = 0;

        for (int i = 0; i < carList.size(); i++) {

            if (this.winnerPoint == carList.get(i).getPosition()) {

                if (manyPeople > 0) {
                    System.out.print(",");
                }

                System.out.print(carList.get(i).getName());
                manyPeople++;
            }
        }

        System.out.println("가 최종 우승했습니다");

    }

    public int getRoundNum() {
        return Integer.parseInt(roundNum);
    }
}