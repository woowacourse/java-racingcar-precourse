package domain;

import java.util.Scanner;

public class Game {
    Scanner scanner;

    private String[] getUserInput() {
        String userInput;
        String[] nameArray;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        userInput = scanner.nextLine();
        nameArray = userInput.split(",");

        return nameArray;
    }

}
