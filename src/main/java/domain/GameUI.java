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
import java.util.ArrayList;

public class GameUI {
    Scanner sc = new Scanner(System.in);
    GameBoard board = new GameBoard();

    public void inputCarNames() {
        String input;

        System.out.println("경주할 자동차의 이름을 입력하세요 (이름은 쉼표(,) 준으로 구분");
        input = sc.nextLine();
        board.createCars(input);
    }

    public void inputCycle() {
        int cycle;

        System.out.println("시도할 횟수는 몇 회인가요?");
        cycle = sc.nextInt();
        board.setCycle(cycle);
    }

    public void playGame() {
        board.play();

    }
}
