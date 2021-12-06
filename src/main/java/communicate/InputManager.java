package communicate;

import java.util.ArrayList;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private void requestCarNames() {
        System.out.println(Text.REQUEST_CAR_NAMES);
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
        requestCarNames();
        String inputCarNames = receiveUserInput();
        ArrayList<String> carNames = separateInputCarNames(inputCarNames);

        return carNames;
    }
}
