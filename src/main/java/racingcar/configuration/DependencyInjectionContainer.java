package racingcar.configuration;

import java.util.Comparator;

import racingcar.domain.Car;
import racingcar.service.JudgmentService;
import racingcar.service.JudgmentServiceImplementation;
import racingcar.validation.InputValidation;
import racingcar.validation.RacingGameValidationImpl;

public class DependencyInjectionContainer {

    public static Comparator<Car> winnerCriteriaPolicy() {
        return new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getPosition() - o1.getPosition();
            }
        };
    }

    public static InputValidation racingGameInputValidation() {
        return RacingGameValidationImpl.getInstance();
    }

    public static JudgmentService judgmentService() {
        return new JudgmentServiceImplementation(winnerCriteriaPolicy());
    }

}
