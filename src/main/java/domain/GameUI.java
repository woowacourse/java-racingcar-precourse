/**
 * class name : GameUI
 *
 * version : V 0.1
 *
 *
 * date : 2019.12.4
 *
 * copyright :
 *
 * description : 입력과 출력을 담당하는 UI Class
 */

package domain;

import java.util.Scanner;

public class GameUI {
    Scanner sc = new Scanner(System.in);
    GameBoard board = new GameBoard();

    public GameUI() {
        inputCarNames();
        inputCycle();
        playGame();
    }

    public void inputCarNames() {
        String input;
        boolean existComma = false;                  //두 개 이상의 car name 존재여부 확인용 변수

        do {
            System.out.println("경주할 자동차의 이름을 입력하세요 (이름은 쉼표(,) 준으로 구분");
            input = sc.nextLine();

            if (input.contains(",")) {
                existComma = true;
            }
        } while (!existComma);

        board.createCars(input);
    }

    public void inputCycle() {
        int cycle;

        do {
            System.out.println("시도할 횟수는 몇 회인가요?");
            cycle = sc.nextInt();
            if (cycle < 0) {
                System.out.println("0이상의 값을 입력해주세요!");
            }
        } while (cycle < 0);
        board.setCycle(cycle);
    }

    public void playGame() {
        System.out.println("실행 결과");
        board.play();

    }
}
