package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

import static racingcar.constant.Constraint.*;
import static racingcar.constant.Message.*;

public class RacingGame {
    private int rounds;
    private Result result;
    private final ArrayList<Car> carList = new ArrayList<>();

    public void run() {
        initGame();
        playGame();
        endGame();
    }

    private void initGame() {
        printInputCarNamesMessage();
        processCarNames();
        createResult();
        printInputRoundsMessage();
        inputRounds();
    }

    private void playGame() {
        for (int i = 0; i < rounds; i++) {
            moveAllCar();
            printResult();
        }
    }

    private void endGame() {
        System.out.println(new Winner(carList).toString());
    }

    private void processCarNames() {
        while (true) {
            try {
                StringTokenizer st = new StringTokenizer(inputCarNames(), DELIM);
                createCars(Validator.validateCarName(st));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                Validator.carNameLinkedHashSet.clear();
            }
        }
    }

    private String inputCarNames() {
        while (true) {
            try {
                String input = Console.readLine();
                Validator.isValidInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void createCars(LinkedHashSet<String> carNamesLinkedHashSet) {
        for (String carName : carNamesLinkedHashSet) {
            carList.add(new Car(carName));
        }
    }

    private void inputRounds() {
        while (true) {
            try {
                rounds = Validator.validateNumber(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void createResult() {
        result = new Result(carList);
    }

    private void moveAllCar() {
        for (Car car : carList) {
            car.moveOrStopCar();
        }
    }

    private void printInputRoundsMessage() {
        System.out.println(INPUT_PLAY_ROUND_MESSAGE);
    }

    private void printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    private void printResult() {
        System.out.println(result.toString());
    }
}
