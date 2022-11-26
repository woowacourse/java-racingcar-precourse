package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.InputView;

public class InputParserImpl implements InputParser {

    public Cars createCars(InputView inputView) {
        String namesOfParticipatingCars = inputView.sendNamesOfParticipatingCars();
        List<Car> cars = Arrays.stream(namesOfParticipatingCars.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public CountOfMoves createCountOfMoves(InputView inputView) {
        String countOfMoves = inputView.sendCountOfMoves();
        int count = convertInputToInt(countOfMoves);
        return new CountOfMoves(count);
    }

    private int convertInputToInt(String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException("숫자를 입력해주세요. 입력값 : " + input);
        }
        return Integer.parseInt(input);
    }

    private boolean isNotNumber(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }
}
