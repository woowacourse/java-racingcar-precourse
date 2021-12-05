package racingcar;

import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputRound;

import racingcar.domain.Cars;
import racingcar.domain.Round;

public class Application {

    public static void main(String[] args) {
        Cars cars = getInputRandomCars();
        Round round = getInputRound();
    }

    private static Cars getInputRandomCars() {
        try {
            return Cars.createRandomCars(inputCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputRandomCars();
        }
    }

    private static Round getInputRound() {
        try {
            return Round.createByStringRound(inputRound());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputRound();
        }
    }
}
