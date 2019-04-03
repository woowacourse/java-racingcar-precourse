package com.game;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Racing {
    private GameManager gameManager = null;
    private String[] names;
    private int moveCount;

    public static void main(String[] args) {
        Racing racing = new Racing();

        racing.userInput();

        racing.gameManager = new GameManager(racing.names);
        while (0 < racing.moveCount--) {
            racing.gameManager.moveCars();
            racing.gameManager.boardPrint();
        }

        racing.winnerPrint();
    }

    void userInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            names = scanner.nextLine().split(",");
            if (checkNames(names)) {
                break;
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        moveCount = scanner.nextInt();
        scanner.nextLine();
    }

    void winnerPrint() {
        final List<String> winner = gameManager.getWinnerNames();
        for (int i = 0; i < winner.size() - 1; ++i) {
            System.out.print(winner.get(i) + ", ");
        }
        System.out.println(winner.get(winner.size() - 1) + "가 최종 우승했습니다.");
    }

    boolean checkNames(final String[] names) {
        HashSet<String> nameSet = new HashSet<>();
        for (String i : names) {
            if (5 < i.length()) {
                System.out.println("이름은 5자 이하여야 합니다.");
                return false;
            }
            if (nameSet.contains(i)) {
                System.out.println("이름이 중복되었습니다.");
                return false;
            }
            nameSet.add(i);
        }
        return true;
    }
}
