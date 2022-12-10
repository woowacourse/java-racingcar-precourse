package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;
import racingcar.Util.TypeParser;
import racingcar.Util.Validation;

import java.util.List;

import static racingcar.Message.Message.INPUT_ATTEND_CARS;
import static racingcar.Message.Message.INPUT_TRY_COUNT;

public class Input extends Validation {

    TypeParser parser = new TypeParser();

    public List<Car> getCars() {
        System.out.println(INPUT_ATTEND_CARS);

        String userInput = Console.readLine();
        validInputCars(userInput);

        return parser.toCarList(userInput);
    }

    public int getTryCount() {
        System.out.println(INPUT_TRY_COUNT);

        String userInput = Console.readLine();
        validTryCount(userInput);

        return Integer.parseInt(userInput);
    }
}
