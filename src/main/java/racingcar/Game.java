package racingcar;

import racingcar.consol.InputConsole;
import racingcar.consol.OutputConsole;

import java.util.Scanner;

public class Game {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private Car[] cars;
    private InputConsole inputConsole;
    private OutputConsole outputConsole;

    public Game(Scanner scanner) {
        inputConsole = new InputConsole(scanner);
        outputConsole = new OutputConsole();
    }

    /* 경주할 자동차 이름, 시도할 횟수 입력 받기 */
    public void start() {
        outputConsole.printInputCarNameMessage();
        inputConsole.getCarNameArray();
    }

    /* 각 차수별로 각 자동차를 전진 또는 멈춤하고 실행 결과 출력 */
    public void showMovingResult() {
    }

    /* 최종 우승자 뽑고 출력 */
    public void finish() {
    }

    public void createRandomNumber() {
    }

    public void judgeMovement() {
    }

    public void selectWinner() {
    }
}
