package racingcar.domain;

import racingcar.Car;
import racingcar.Race;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;

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
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
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
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
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
