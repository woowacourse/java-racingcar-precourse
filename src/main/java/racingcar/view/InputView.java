package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.message.ErrorMessage.TRY_COUNT_MUST_BE_NUMBER;

public class InputView {

    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public CarGroup inputCarName() {
        outputView.printInputRacing();
        String input = Console.readLine();
        String[] split = input.split(",");

        List<Car> cars = Arrays.stream(split)
                .map(Car::new)
                .collect(Collectors.toList());

        return new CarGroup(cars);
    }

    public int inputTryCount() {
        outputView.printInputTryCount();
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_MUST_BE_NUMBER.getMessage());
        }
    }
}
