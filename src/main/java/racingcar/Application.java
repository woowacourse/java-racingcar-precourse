package racingcar;

import racingcar.controller.SingleGame;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        SingleGame singleGame = new SingleGame();
        singleGame.play(scanner);
        scanner.close();
    }
}
