package racingcar.domain;

import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;

import static racingcar.util.Constant.CAR_NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.util.Constant.NOT_DIGIT_ERROR_MESSAGE;

public class Game {
    private Race race;


    private void getCarByName() {
        try {
            OutputView.printInputCarGuideMessage();
            String userInput = InputView.getUserInput();
            String[] carNames = userInput.split(",");
            ArrayList<Car> cars = createCarList(carNames);
            race = new Race(cars);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            getCarByName();
        }
    }

    private ArrayList<Car> createCarList(String[] carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
            }
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    private void getMoveCount() {
        try {
            OutputView.printInputNumberGuideMessage();
            String userInput = InputView.getUserInput();
            if(!userInput.chars().allMatch(Character::isDigit)){
                throw new IllegalArgumentException(NOT_DIGIT_ERROR_MESSAGE);
            }
            race.setMoveCount(Integer.parseInt(userInput));
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            getMoveCount();
        }
    }

    public void run() {
        getCarByName();
        getMoveCount();
        OutputView.printNewLine();
        OutputView.printExcutionResult();
        race.run();
    }
}
