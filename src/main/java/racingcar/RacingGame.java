package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.RandomNumberGenerator;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

import static racingcar.constant.Constraint.*;
import static racingcar.constant.Message.*;

public class RacingGame {
    private Result result;
    private int rounds;
    ArrayList<Car> carList = new ArrayList<>();

    public void run() {
        initGame();
        startGame();
        printWinner();
    }

    private void initGame() {
        printInputCarNamesMessage();
        processCarNames();
        createResult();
        printInputRoundsMessage();
        inputRounds();
    }

    private void processCarNames() {
        while(true) {
            try {
                StringTokenizer st = new StringTokenizer(inputCarNames(), DELIM);
                createCars(Validator.validateCarName(st));
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                Validator.carNameLinkedHashSet.clear();
            }
        }
    }

    private String inputCarNames() {
        while(true) {
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
        for(String carName : carNamesLinkedHashSet) {
            carList.add(new Car(carName));
        }
    }

    private void inputRounds() {
        while(true) {
            try {
                rounds = Validator.validateNumber(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printWinner() {
        System.out.println(OUTPUT_WINNER_MESSAGE + checkWinner());
    }

    private String checkWinner() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Car car : carList) {
            appendIfRaceWinner(stringBuilder, car);
        }

        return stringBuilder.toString();
    }

    private void appendIfRaceWinner(StringBuilder stringBuilder, Car car) {
        if(isWinner(car)) {
            appendIfNotFirstWinner(stringBuilder);
            stringBuilder.append(car.getName());
        }
    }

    private void appendIfNotFirstWinner(StringBuilder stringBuilder) {
        if(stringBuilder.length() != NONE) {
            stringBuilder.append(WINNER_MORE_THAN_ONE_MESSAGE);
        }
    }

    private boolean isWinner(Car car) {
        return car.getPosition() == result.getMax();
    }

    private void printInputRoundsMessage() {
        System.out.println(INPUT_PLAY_ROUND_MESSAGE);
    }

    private void printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    private void createResult() {
        result = new Result(carList);
    }

    private void startGame() {
        for(int i = 0; i < rounds; i++) {
            moveAllCar();
            printResult();
        }
    }

    private void printResult() {
        System.out.println(result.toString());
    }

    private void moveAllCar() {
        for(Car car : carList) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        if(canCarMove()) {
            car.moveCarForward();
        }
    }

    private boolean canCarMove() {
        return RandomNumberGenerator.getRandomNumber() >= MOVING_FORWARD;
    }
}
