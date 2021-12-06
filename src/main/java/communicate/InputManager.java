package communicate;

import java.util.ArrayList;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private Validation validator = new Validation();

    private void requestCarNames() {
        System.out.println(Text.REQUEST_CAR_NAMES);
    }

    private void requestAttemptNumber() {
        System.out.println(Text.REQUEST_ATTEMPT_NUMBER);
    }

    private String receiveUserInput() {
        return Console.readLine();
    }

    private ArrayList<String> separateInputCarNames(String inputCarNames) {
        ArrayList<String> carNames = new ArrayList<>();
        StringTokenizer names = new StringTokenizer(inputCarNames, Text.SEPARATOR_COMMA);

        while (names.hasMoreTokens()) {
            carNames.add(names.nextToken());
        }

        return carNames;
    }

    public ArrayList<String> provideCarNames() {

        while (true) {
            requestCarNames();
            String inputCarNames = receiveUserInput();
            ArrayList<String> carNames = separateInputCarNames(inputCarNames);

            if (validator.isValidCarNames(carNames)) {
                return carNames;
            }

        }

    }

    public int provideAttemptNumber() {

        while (true) {
            requestAttemptNumber();
            String attemptNumber = receiveUserInput();

            if (validator.isValidAttemptNumber(attemptNumber)) {
                return Integer.valueOf(attemptNumber);
            }

        }

    }
}
