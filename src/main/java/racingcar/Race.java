package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;

public class Race {
    private static ArrayList<Car> cars = new ArrayList<>();
    private static ArrayList<Car> winnerCars = new ArrayList<>();
    private static int moveCount;
    public static int maxDistance;


    public static void getCarByName() {
        try {
            OutputView.printInputCarGuideMessage();
            String userInput = InputView.getUserInput();
            String[] carNames = userInput.split(",");
            for (String carName : carNames) {
                if (carName.length() > 5) {
                    throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
                }
                Car car = new Car(carName);
                cars.add(car);
            }
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            getCarByName();
        }
    }

    public static void getMoveCount() {
        try {
            OutputView.printInputNumberGuideMessage();
            String userInput = InputView.getUserInput();
            if(!userInput.chars().allMatch(Character::isDigit)){
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
            }
            moveCount = Integer.parseInt(userInput);
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
        while (moveCount > 0) {
            for (Car car : cars) {
                car.move();
                car.printPosition();
            }
            OutputView.printNewLine();
            moveCount--;
        }
        calculateMaxDistance();
        decideWinner();
        showWinner();
    }

    public void calculateMaxDistance() {
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getPosition());
        }
    }

    public void decideWinner() {
        for (Car car : cars) {
            if (car.getPosition() == maxDistance) {
                winnerCars.add(car);
            }
        }
    }

    public void showWinner() {
        int winnerCount = winnerCars.size();
        String[] winnerCarNames = new String[winnerCount];
        for (int i = 0; i < winnerCount; i++) {
            winnerCarNames[i] = winnerCars.get(i).getName();
        }
        OutputView.printFinalWinnerBy(winnerCarNames);
    }

}
