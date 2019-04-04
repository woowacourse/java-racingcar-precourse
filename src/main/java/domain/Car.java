/*
 * @(#)Car.java             1.0.0 2019/04/04
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
 * 자동차의 이름, 위치, 자동차의 주행을 관리하는 클래스
 *
 * randomNumGenerator: 랜덤수 생성(1~9)
 * goAndStop : 전진과 정지에 따른 위치계산
 * printDistance : 자동차가 전진한 거리 출력
 *
 * @author Kris Kim
 *
 * */

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private int randomNumGenerator() {

        int randomNumber = 0;

        while (true) {

            randomNumber = (int) (Math.random() * 10);

            if (randomNumber == 0)
                continue;
            return randomNumber;
        }
    }

    public void goAndStop() {

        if (randomNumGenerator() >= 4)
            this.position++;

    }

    public void printDistance() {

        System.out.print(this.name + ":");

        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
}
