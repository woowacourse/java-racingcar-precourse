package com.game;

import java.util.HashSet;
import java.util.Scanner;

public class Racing {
    public static void main(String[] args) {
        Racing racing = new Racing();
        Scanner scanner = new Scanner(System.in);

        String[] names = null;
        while (true) {
            names = scanner.nextLine().split(",");
            if (!racing.checkNames(names)) {
                break;
            }
        }

        int moveCount = scanner.nextInt();
        scanner.nextLine();

        GameManager gameManager = new GameManager(names);
        while (0 < moveCount--) {
            gameManager.moveCars();
        }
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
