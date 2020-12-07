package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int COUNT_MINIMUM = 1;
    private static final String SET_CAR_NAME_LIST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SET_RACING_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSGAE_END_COUNT_ISINT = "시도할 회수는 숫자여야 한다.";
    private static final String ERROR_MESSGAE_END_COUNT_ISBIGGERZERO = "시도할 회수는 0보다 커야 한다.";

    private int roundCount;
    private List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarNameList(Scanner scanner) {
        System.out.println(SET_CAR_NAME_LIST_MESSAGE);
        String scannerInput = scanner.nextLine();
        if (scannerInput != null) {
            carList = new ArrayList<>();
            for (String carName : scannerInput.split(",")) {
                carList.add(new Car(carName.trim()));
            }
        }
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(Scanner scanner) {
        System.out.println(SET_RACING_COUNT_MESSAGE);
        String scannerInput = scanner.nextLine();
        if (scannerInput != null) {
            validateType(scannerInput);
            int scannerInputToInt = Integer.parseInt(scannerInput);
            validateRange(scannerInputToInt);
            roundCount = scannerInputToInt;
        }
    }

    private void validateType(String scannerInput) {
        try{
            Integer.parseInt(scannerInput);
        } catch (NumberFormatException E) {
            throw new IllegalArgumentException(ERROR_MESSAGE_START + ERROR_MESSGAE_END_COUNT_ISINT);
        }
    }

    private void validateRange(int scannerInputToInt) {
        if (scannerInputToInt < COUNT_MINIMUM) {
            throw new IllegalArgumentException(ERROR_MESSAGE_START + ERROR_MESSGAE_END_COUNT_ISBIGGERZERO);
        }
    }

}
