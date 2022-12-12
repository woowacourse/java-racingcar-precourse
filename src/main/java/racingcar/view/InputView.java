package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.domain.TryCount;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public TryCount inputTryCount() {
        outputView.printInputTryCount();
        String input = Console.readLine();
        return new TryCount(input);
    }
}
