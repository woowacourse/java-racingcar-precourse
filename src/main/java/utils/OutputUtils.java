package utils;

import java.util.Scanner;
import utils.InputUtils;

public class Output {

    private static final String pleaseInputCarNames = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String pleaseInputLoopTime = "시도할 회수는 몇회인가요?";
    private static final String errorLoopTimeInteger = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private static final String errorNameLessThanFive = "[ERROR] 자동차 이름은 5자 이하여야 한다.";

    public String printPleaseInputCarNames(Scanner scanner) {
        System.out.println(pleaseInputCarNames);
        return getInputCarNames(scanner);
    }

    public int printPleaseInputLoopTime(Scanner scanner) {
        System.out.println(pleaseInputLoopTime);
        return getInputLoopTime(scanner);
    }

    private String getInputCarNames(Scanner scanner) {
        String carNames = scanner.nextLine();
        if (InputUtils.isNameLessThanFive(carNames)) {
            return carNames;
        }

        System.out.println(errorNameLessThanFive);
        return printPleaseInputCarNames(scanner);
    }

    private int getInputLoopTime(Scanner scanner) {
        String loopTime = scanner.nextLine();
        if (InputUtils.isLoopTimeInteger(loopTime)){
            return Integer.parseInt(loopTime);
        }

        System.out.println(errorLoopTimeInteger);
        return printPleaseInputLoopTime(scanner);
    }

}
