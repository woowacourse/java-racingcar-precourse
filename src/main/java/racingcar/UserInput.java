package racingcar;

import java.util.Scanner;

public class UserInput {
    final static String inputNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final static String playTimeMessage = "시도할 회수는 몇회인가요?";

    public static String[] makeCarsList(Scanner scanner) {
        System.out.println(inputNameMessage);
        String cars = scanner.nextLine();
        String[] carsList = cars.split(",");
        for (int i = 0; i < carsList.length; i++) {
            carsList[i] = carsList[i].strip();
        }
        try {
            ErrorValidator.checkCarNameInput(carsList);
            return carsList;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return makeCarsList(scanner);
        }
    }

    public static int makePlayTime(Scanner scanner) {
        System.out.println(playTimeMessage);
        String playTime = scanner.nextLine();
        try {
            ErrorValidator.checkNumeric(playTime);
            return Integer.parseInt(playTime);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return makePlayTime(scanner);
        }
    }
}