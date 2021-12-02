package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

import static racingcar.constant.Constraint.*;
import static racingcar.constant.Message.*;

public class RacingGame {
    private Result result;
    private int moves;
    ArrayList<Car> carList = new ArrayList<>();
    LinkedHashSet<String> carNameLinkedHashSet = new LinkedHashSet<>();

    public void run() {
        initGame();
        startGame();
        printWinner();
    }

    private void printWinner() {
        System.out.println(OUTPUT_WINNER_MESSAGE + checkWinner());
    }

    private String checkWinner() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Car car : carList) {
            appendIfWinner(stringBuilder, car);
        }

        return stringBuilder.toString();
    }

    private void appendIfWinner(StringBuilder stringBuilder, Car car) {
        if(isWinner(car)) {
            appendIfNotFirst(stringBuilder);
            stringBuilder.append(car.getName());
        }
    }

    private void appendIfNotFirst(StringBuilder stringBuilder) {
        if(stringBuilder.length() != NONE) {
            stringBuilder.append(WINNER_MORE_THAN_ONE_MESSAGE);
        }
    }

    private boolean isWinner(Car car) {
        return car.getPosition() == result.getMax();
    }

    private void initGame() {
        printMessageForCarNames();
        processCarName();
        createResult();
        printMessageForNumberOfMoves();
        inputMoves();
    }

    private void printMessageForNumberOfMoves() {
        System.out.println(INPUT_PLAY_ROUND_MESSAGE);
    }

    private void printMessageForCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    private void createResult() {
        result = new Result(carList);
    }

    private void startGame() {
        for(int i = 0; i < moves; i++) {
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

    private String inputCarNames() {
        while(true) {
            try {
                String input = Console.readLine();
                isValidInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void isValidInput(String input) {
        if(!input.matches("^[a-zA-Z]+(,[a-zA-Z]+)+$")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_MESSAGE + RETRY_MESSAGE);
        }
    }

    private void inputMoves() {
        boolean flag = false;

        do {
            try {
                validateNumber(Console.readLine());
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }while(!flag);
    }

    private void validateNumber(String input) {
        if(!input.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LIMITED_TO_NUMBER_ONLY_MESSAGE + RETRY_MESSAGE);
        }

        moves = Integer.parseInt(input);
    }

    private void processCarName() {
        boolean isValid = false;

        do {
            try {
                StringTokenizer st = new StringTokenizer(inputCarNames(), DELIM);
                validateCarName(st);
                isValid = true;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                carNameLinkedHashSet.clear();
            }
        } while(!isValid);

        createCars();
    }

    private void createCars() {
        for(String carName : carNameLinkedHashSet) {
            carList.add(new Car(carName));
        }
    }

    private void validateCarName(StringTokenizer stringTokenizer) throws IllegalArgumentException {
        while(stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            validateNameLength(nextToken);
            validateDuplicateName(nextToken);
            carNameLinkedHashSet.add(nextToken);
        }
    }

    private void validateDuplicateName(String nextToken) {
        if (carNameLinkedHashSet.contains(nextToken)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_CAR_NAME_MESSAGE + RETRY_MESSAGE);
        }
    }

    private void validateNameLength(String carName) {
        if(isValidLength(carName)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + CAR_NAME_LENGTH_TOO_LONG_MESSAGE + RETRY_MESSAGE);
        }
    }

    private boolean isValidLength(String carName) {
        return carName.length() > MAX_CAR_NAME_LENGTH;
    }
}
