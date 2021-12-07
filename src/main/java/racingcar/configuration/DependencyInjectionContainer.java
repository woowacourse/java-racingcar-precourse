package racingcar.configuration;

import java.util.Comparator;

import racingcar.domain.Car;
import racingcar.racingsystem.RacingGame;
import racingcar.service.JudgmentService;
import racingcar.service.JudgmentServiceImplementation;
import racingcar.validation.InputValidation;
import racingcar.validation.RacingGameValidationImplementation;

public class DependencyInjectionContainer {

    public Comparator<Car> winnerCriteriaPolicy() {
        return new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getPosition() - o1.getPosition();
            }
        };
    }

    public RacingGame racingGame() {
        return new RacingGame(racingGameInputValidation(), judgmentService());
    }

    public InputValidation racingGameInputValidation() {
        return RacingGameValidationImplementation.getInstance();
    }

    public JudgmentService judgmentService() {
        return JudgmentServiceImplementation.getInstance();
    }

}
