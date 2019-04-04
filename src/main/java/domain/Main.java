/*
 * @(#)Main.java             1.0.0 2019/04/04
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

/*
 * 게임을 실행하는 클래스
 * - 게임 시작 기능 구현
 * - 입력 받은 시도 횟수 만큼 레이싱을 실행하는 기능 구현
 *
 * @author Kris Kim
 * */

package domain;


public class Main {

    public static void main(String[] args) {

        Gameplay module = new Gameplay();

        module.initSetup();

        for (int i = 0; i < module.getRoundNum(); i++) {
            module.doRace();
        }

        module.checkWinner();

    }
}
