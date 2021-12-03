package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarGame {
    private UserInput userInput;
    private List<Car> cars;

    public RacingCarGame() {
        this.userInput = new UserInput();
    }

    public void start() {
        getInput();
        System.out.println(Constant.EXECUTION_RESULT);
        for (int i = 0; i < userInput.getAttempt(); i++) {
            play();
            printExecutionResult();
        }
    }

    private void getInput() {
        userInput.inputNames();
        makeCarList(userInput.getNames());
        userInput.inputAttempt();
    }

    private void makeCarList(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.cars = cars;
    }

    private void play() {
        for (Car car : cars) {
            if (MoveOrNot()) {
                car.move();
            }
        }
    }

    private boolean MoveOrNot() {
        int num = Randoms.pickNumberInRange(Constant.MINIMUM_NUMBER_OF_RANDOM, Constant.MAXIMUM_NUMBER_OF_RANDOM);
        if (num >= Constant.NUMBER_FOR_MOVE) {
            return true;
        }
        return false;
    }

    private void printExecutionResult() {
        StringBuilder execution_result = new StringBuilder();
        for (Car car : cars) {
            execution_result.append(car.printPosition());
        }
        System.out.println(execution_result);
    }

}
