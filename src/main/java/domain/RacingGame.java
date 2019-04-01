package domain;

import java.util.Scanner;
public class RacingGame {

    private String getInputConsole() {
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }

    private boolean isValidInput(String input) {
        if (input.length() > 5 && !input.contains(",")) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private void invalidInputMessage() {
        System.out.println("잘못된 입력입니다.");
    }

    private String[] splitCarName(String input) {
        return input.split(",");
    }

    private CarGroup reacyCarGroup(String input) {
        String[] names = splitCarName(input);

        CarGroup cg = new CarGroup(names);

        return cg;
    }

    private void printConsole(String string) {
        System.out.println(string);
    }

    private String getResult(CarGroup cg) {
        return cg.getRaceState();
    }

    private String getWinner(CarGroup cg) {
        return cg.getMaxCar();
    }

    public void startRace() {
        String inputName;
        String gameCountString;
        int gameCountNumber;

        while (true) {
            String guidInputCarNameMessage = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분";
            printConsole(guidInputCarNameMessage);
            inputName = getInputConsole();

            if (isValidInput(inputName)) {
                break;
            }

            invalidInputMessage();
        }

        while (true) {
            printConsole("시도할 횟수는 몇 회인가요?");
            gameCountString = getInputConsole();

            if (isNumber(gameCountString)) {
                break;
            }

            invalidInputMessage();
        }

        gameCountNumber = Integer.parseInt(gameCountString);
        CarGroup cg = reacyCarGroup(inputName);

        while (gameCountNumber > 0) {
            cg.makeCarRace();
            printConsole(getResult(cg));
            gameCountNumber--;
        }

        printConsole(getWinner(cg));
    }

}
