package racingcar;

import java.util.Scanner;

public class GamePlayer {

    public String[] inputNamesOfCars(Scanner scanner) {
        String namesOfCars = scanner.nextLine();
        return namesOfCars.split(",");
    }

    public int inputTurnsToTry(Scanner scanner) {
        System.out.println("시도할 횟수는 몇회인가요?");
        String turnsToTry = scanner.nextLine();
        int turnsToTryInt = 0;
        try {
            turnsToTryInt = Integer.parseInt(turnsToTry);
        } catch (NumberFormatException nfe) {
            System.err.println("[ERROR] 숫자를 입력해주세요.");
            turnsToTryInt = inputTurnsToTry(scanner);
        }
        return turnsToTryInt;
    }
}
