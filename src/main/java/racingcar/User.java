package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UserInput {

    private static final String NAME_SEPARATOR = ",";

    public String inputValue() {
        return Console.readLine();
    }

    public List<Car> splitInputCarNames(final String inputCarNames) {
        final StringTokenizer stringTokenizer = new StringTokenizer(inputCarNames, NAME_SEPARATOR);
        final List<Car> carNames = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            carNames.add(new Car(stringTokenizer.nextToken()));
        }

        return carNames;
    }

}
