package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.model.Car;
import racingcar.domain.model.Cars;
import racingcar.domain.model.CountOfMoves;
import racingcar.view.InputView;

public class RacingGameGeneratorImpl implements RacingGameGenerator {

    private final InputView inputView;

    public RacingGameGeneratorImpl(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public RacingGame generate() {
        Cars cars = createCars();
        CountOfMoves countOfMoves = createCountOfMoves();
        return new RacingGame(cars, countOfMoves);
    }

    protected Cars createCars() {
        String namesOfParticipatingCars = inputView.sendNamesOfParticipatingCars();
        List<Car> cars = getCars(namesOfParticipatingCars);
        return new Cars(cars);
    }

    protected CountOfMoves createCountOfMoves() {
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
