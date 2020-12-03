package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SET_CAR_NAME_LIST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SET_RACING_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final int CAR_NAME_LENGTH_INCLUSIVE_START = 1;
    private static final int CAR_NAME_LENGTH_INCLUSIVE_END = 5;
    private static final int COUNT_MINIMUM = 1;
    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSGAE_END_COUNT_ISINT = "시도할 회수는 숫자여야 한다.";
    private static final String ERROR_MESSGAE_END_COUNT_ISBIGGERZERO = "시도할 회수는 0보다 커야 한다.";
    private static final String ERROR_MESSGAE_END_NAME_ISINBOUND = "경주할 자동차 이름은 1글자 이상, 5글자 이하여야 한다.";


    private final Scanner scanner;
    private int racingCount;
    private List<String> carNameList;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> getCarNameList() {
        return carNameList;
    }

    public void setCarNameList() {
        System.out.println(SET_CAR_NAME_LIST_MESSAGE);
        String scannerInput = scanner.nextLine();
        if (isValidCarNameList(scannerInput)) {
            carNameList = new ArrayList<>();
            for (String carName : scannerInput.split(",")) {
                carNameList.add(carName.trim());
            }
        }
    }

    private boolean isValidCarNameList(String scannerInput) {
        if (!isInBound(scannerInput, CAR_NAME_LENGTH_INCLUSIVE_START, CAR_NAME_LENGTH_INCLUSIVE_END)) {
            System.out.println(ERROR_MESSAGE_START + ERROR_MESSGAE_END_NAME_ISINBOUND);
            return false;
        }
        return true;
    }

    private boolean isInBound(String scannerInput, int startInclusive, int endInclusive) {
        for (String carName : scannerInput.split(",")) {
            int carNameLength = carName.trim().length();
            if (carNameLength < startInclusive || carNameLength > endInclusive) {
                return false;
            }
        }
        return true;
    }

    public int getRacingCount() {
        return racingCount;
    }

    public void setRacingCount() {
        System.out.println(SET_RACING_COUNT_MESSAGE);
        String scannerInput = scanner.nextLine();
        if (isValidRacingCount(scannerInput)) {
            racingCount = Integer.parseInt(scannerInput);
        }
    }

    private boolean isValidRacingCount(String scannerInput) {
        if (!isInt(scannerInput)) {
            System.out.println(ERROR_MESSAGE_START + ERROR_MESSGAE_END_COUNT_ISINT);
            return false;
        }
        int scannerInputToInt = Integer.parseInt(scannerInput);
        if (!isBiggerZero(scannerInputToInt)) {
            System.out.println(ERROR_MESSAGE_START + ERROR_MESSGAE_END_COUNT_ISBIGGERZERO);
            return false;
        }
        return true;
    }

    private boolean isInt(String scannerInput) {
        try {
            Integer.parseInt(scannerInput);
        } catch (NumberFormatException E) {
            return false;
        }
        return true;
    }

    private boolean isBiggerZero(int scannerInputToInt) {
        if (scannerInputToInt < COUNT_MINIMUM) {
            return false;
        }
        return true;
    }
}
