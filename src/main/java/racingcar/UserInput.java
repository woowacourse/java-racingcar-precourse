package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UserInput {

    public static final String DELIMITER = ",";
    public static final int START_POSITION = 0;

    public String inputCarNames() {
        return Console.readLine();
    }

    public List<Car> splitInputCarNames(final String inputCarNames) {
        final StringTokenizer stringTokenizer = new StringTokenizer(inputCarNames, DELIMITER);
        final List<Car> carNames = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            carNames.add(new Car(stringTokenizer.nextToken(), START_POSITION));
        }

        return carNames;
    }

}
