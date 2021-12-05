package racingcar;

import static racingcar.view.InputView.inputCarNames;

import racingcar.domain.Cars;

public class Application {
    public static void main(String[] args) {
        Cars cars = createRandomCars();
    }

    private static Cars createRandomCars() {
        try {
            return Cars.createRandomCars(inputCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createRandomCars();
        }
    }
}
