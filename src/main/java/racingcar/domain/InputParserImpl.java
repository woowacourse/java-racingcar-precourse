package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.InputView;

public class InputParserImpl implements InputParser {

    private final InputView inputView;

    public InputParserImpl(InputView inputView) {
        this.inputView = inputView;
    }

    public Cars createCars() {
        String namesOfParticipatingCars = inputView.sendNamesOfParticipatingCars();
        List<Car> cars = getCars(namesOfParticipatingCars);
        return new Cars(cars);
    }

    public CountOfMoves createCountOfMoves() {
        String countOfMoves = inputView.sendCountOfMoves();
        int count = convertInputToInt(countOfMoves);
        return new CountOfMoves(count);
    }

    private List<Car> getCars(String namesOfParticipatingCars) {
        return Arrays.stream(namesOfParticipatingCars.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
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
