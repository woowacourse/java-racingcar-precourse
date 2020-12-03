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
            System.err.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            turnsToTryInt = inputTurnsToTry(scanner);
        }
        return getAbsoluteValue(turnsToTryInt);
    }

    public int getAbsoluteValue(int turnsToTryInt) {
        if (turnsToTryInt < 0) {
            System.err.println("[ERROR] 음수는 절대값이 입력됩니다.");
            return Math.abs(turnsToTryInt);
        }
        return turnsToTryInt;
    }
}
