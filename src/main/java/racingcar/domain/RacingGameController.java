package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarPositionDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGame racingGame;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGame racingGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGame = racingGame;
    }

    public void run() {
        Cars cars = createCars();
        int count = createCount();
        for (int i = 0; i < count; i++) {
            racingGame.play(cars);
            outputView.printCarsPosition(getCarPosition(cars));
        }
    }

    private Cars createCars() {
        String namesOfParticipatingCars = inputView.sendNamesOfParticipatingCars();
        List<Car> cars = Arrays.stream(namesOfParticipatingCars.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private int createCount() {
        return convertInputToInt(inputView.sendCountOfMoves());
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

    private List<CarPositionDto> getCarPosition(Cars cars) {
        return cars.getCars()
                .stream()
                .map(CarPositionDto::of)
                .collect(Collectors.toList());
    }
}
