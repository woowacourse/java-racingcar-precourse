package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class GameSetting {
    final static String inputCarNamePrint = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final static String inputTrackLengthPrint = "시도할 회수는 몇회인가요?";
    final static String exceptionCarNamePrint = "[ERROR] 이름은 5자 이하만 입력 가능";
    final static String exceptionTrackLengthPrint = "[ERROR] 1 이상인 정수만 입력 가능";

    public static ArrayList<Car> carListCatchException(Scanner scanner) {
        ArrayList<Car> result;
        while (true) {
            try {
                result = carList(scanner);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    static int trackLengthCatchException(Scanner scanner) {
        int result;
        while (true) {
            try {
                result = trackLength(scanner);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    static ArrayList<Car> carList(Scanner scanner) {
        ArrayList<Car> result = new ArrayList<Car>();
        String inputString = inputAndOutput.inputString(scanner, inputCarNamePrint);
        nameStringException(inputString);
        String[] carNameList = carNameList(inputString);
        for (int i = 0; i < carNameList.length; i++) {
            nameLengthException(carNameList[i]);
            result.add(new Car(carNameList[i]));
        }
        return result;
    }

    static String[] carNameList(String inputString) {
        String[] carNameList = inputString.split(",");
        if (carNameList.length == 0) {
            throw new IllegalArgumentException(exceptionCarNamePrint);
        }
        return carNameList;
    }

    static int trackLength(Scanner scanner) {
        String resultString = inputAndOutput.inputString(scanner, inputTrackLengthPrint);
        int result;
        try {
            result = Integer.parseInt(resultString);
        } catch (Exception e) {
            throw new IllegalArgumentException(exceptionTrackLengthPrint);
        }
        if (result <= 0) {
            throw new IllegalArgumentException(exceptionTrackLengthPrint);
        }
        return result;
    }

    static void nameLengthException(String carName) {
        if ((carName.length() > 5) || carName.equals("")) {
            throw new IllegalArgumentException(exceptionCarNamePrint);
        }
    }

    static void nameStringException(String inputString) {
        String lastChar = inputString.substring(inputString.length() - 1, inputString.length());
        if (lastChar.equals(",")) {
            throw new IllegalArgumentException(exceptionCarNamePrint);
        }
    }
}
