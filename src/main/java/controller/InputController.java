package controller;

import java.util.Scanner;

public class InputController {
    private Scanner scanner;

    public InputController() {
        this.scanner = new Scanner(System.in);
    }

    public String[] getNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = this.scanner.nextLine();
        //    TODO: 예외 처리
        String[] carNames = userInput.split(",");
        return carNames;
    }

    public int getTimesToRun() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = this.scanner.nextLine();
        //    TODO: 예외 처리
        return Integer.parseInt(userInput);
    }
}
