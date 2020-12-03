package racingcar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 입력값을 처리하는 클래스
 */
public class InputGuide {

    private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVES_INPUT_MESSAGE = "시도할 횟수는 몇회인가요? : ";
    private static final String CAR_NAME_INPUT_EXCEPTION_MESSAGE = "자동차 이름은 0자 이상 5자 이내여야 합니다.";
    private static final String CAR_NUMBERS_INPUT_EXCEPTION_MESSAGE = "자동차 갯수는 2개 이상이어야 합니다.";
    private static final String MOVES_INPUT_EXCEPTION_MESSAGE = "자연수를 입력해야 합니다.";
    private static final String REST = ",";
    private static final int FIVE = 5;
    private static final int TWO = 2;
    public static final int ZERO = 0;
    private final Scanner scanner;
    private Car[] cars;

    InputGuide(Scanner scanner) {
        this.scanner = scanner;
    }

    public Car[] inputCars() {
        System.out.println(CAR_INPUT_MESSAGE);
        String[] cars = splitCarsName(scanner.nextLine());
        try{
            return isValid(cars);
        } catch(ErrorException exception){
            System.out.println(exception.getMessage());
            return inputCars();
        }
    }

    private Car[] isValid(String[] cars) {
        if (isMoreThanOne(cars)) {
            return makeCar(cars);
        }
        throw new ErrorException(CAR_NUMBERS_INPUT_EXCEPTION_MESSAGE);
    }

    private String[] splitCarsName(String input) {
        return input.split(REST);
    }

    private boolean isMoreThanOne(String[] input) {
        if (Arrays.stream(input).count() >= TWO) {
            return isValidateCarNames(input);
        }
        throw new ErrorException(CAR_NUMBERS_INPUT_EXCEPTION_MESSAGE);
    }

    private boolean isValidateCarNames(String[] input) {
        if(Arrays.stream(input).allMatch(this::countCharacters)){
            return true;
        }
        throw new ErrorException(CAR_NAME_INPUT_EXCEPTION_MESSAGE);
    }

    private boolean countCharacters(String carName) {
        return carName.length() < FIVE && carName.length() > ZERO;
    }

    private Car[] makeCar(String[] names) {
        cars = new Car[names.length];
        for (int i = 0, length = names.length; i < length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

    public int countMove() {
        System.out.println(MOVES_INPUT_MESSAGE);
        try {
            return moreThanZero();
        } catch (ErrorException exception) {
            System.out.println(exception.getMessage());
            return countMove();
        }
    }

    private int moreThanZero(){
        try{
            int input = Integer.parseInt(scanner.nextLine());
            return isNaturalNumber(input);
        } catch (NumberFormatException | ErrorException exception) {
            throw new ErrorException(MOVES_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private int isNaturalNumber(int input) {
        if (input > 0) {
            return input;
        }
        throw new ErrorException(MOVES_INPUT_EXCEPTION_MESSAGE);
    }
}
