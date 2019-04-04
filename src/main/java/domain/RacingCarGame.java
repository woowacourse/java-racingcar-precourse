/*
* RacingCarGame.java 2019.04.04
*
* Copyright (c) 2019 Jong Min Lee
*
* ProgrammingLanguage Java
 */
package domain;

public class RacingCarGame {

    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.askCarsName();
        controller.askNumberOfAttempts();
        controller.startGame();

        System.out.println("\n실행 결과");

        /* 매 순간의 자동차의 위치를 체크해서 출력하기 위한 코드 */
        for (int i = 0; i < controller.getLaps(); i++) {
            controller.checkCarsPosition();
        }

        controller.checkWinner();
    }

}
