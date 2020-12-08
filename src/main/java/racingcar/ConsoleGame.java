package racingcar;

import static racingcar.UtilityFunctions.parseCarNameArrayString;
import static racingcar.UtilityFunctions.parseMaxAttemptString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleGame {

    private final Scanner scanner;

    public ConsoleGame(Scanner scanner) {
        this.scanner = scanner;
    }

    private String[] getCarNameArray() {
        String[] carNameArray;
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                final String carNameArrayString = scanner.nextLine();
                carNameArray = parseCarNameArrayString(carNameArrayString);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return carNameArray;
    }

    private int getMaxAttempt() {
        int maxAttempt;
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                final String maxAttemptString = scanner.nextLine();
                maxAttempt = parseMaxAttemptString(maxAttemptString);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return maxAttempt;
    }

    private String generateCarStatusString(Car car) {
        final StringBuilder carStatus = new StringBuilder();
        carStatus.append(car.getName());
        carStatus.append(" : ");
        for (int barAmount = 0; barAmount < car.getPosition(); barAmount++) {
            carStatus.append("-");
        }
        return carStatus.toString();
    }

    private void printLapResult(RacingCircuit racingCircuit) {
        for (Car car : racingCircuit.getCarList()) {
            System.out.println(generateCarStatusString(car));
        }
        System.out.println();
    }

    private List<String> getRaceWinnerNameList(RacingCircuit racingCircuit) {
        int maxPosition = 0;
        final List<String> raceWinnerNameList = new ArrayList<>();

        for (Car car : racingCircuit.getCarList()) {
            if (maxPosition == car.getPosition()) {
                raceWinnerNameList.add(car.getName());
            }
            if (maxPosition < car.getPosition()) {
                raceWinnerNameList.clear();
                raceWinnerNameList.add(car.getName());
                maxPosition = car.getPosition();
            }
        }

        return raceWinnerNameList;
    }

    private void printRaceResult(List<String> raceWinnerNameList) {
        System.out.println("최종 우승자: " + String.join(", ", raceWinnerNameList));
    }

    public void run() {
        final String[] carNameArray = getCarNameArray();
        final int maxAttempt = getMaxAttempt();

        System.out.println();
        System.out.println("실행 결과");

        final RaceGame raceGame = new RaceGame(carNameArray, maxAttempt);
        while (!raceGame.isFinished()) {
            raceGame.accelerateCars();
            printLapResult(raceGame.getRacingCircuit());
        }

        final List<String> raceGameWinnerList = getRaceWinnerNameList(raceGame.getRacingCircuit());
        printRaceResult(raceGameWinnerList);
    }
}
