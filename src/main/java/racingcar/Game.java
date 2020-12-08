package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static final String GAME_RESULT_MESSAGE = "실행결과";
    
    private Input input;
    private Output output;
    private Exception exception;
    
    private ArrayList<Car> cars = new ArrayList<Car>();
    private int numberOfTry;
    
    public Game(Scanner scanner) {
        input = new Input(scanner);
        exception = new Exception();
    }
    
    public void run() {
        inputCarName();
        inputNumberOfTry();
        printRoundOfGameResult();
        printFinalWinner();
    }
    
    public void inputCarName() {
        String[] carNames = input.getCarNames();
        exception.checkCarNameException(carNames);
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }
    public void inputNumberOfTry() {
        numberOfTry = input.getNumberOfTry();
        exception.checkNumberOfTryException(numberOfTry);
        System.out.println();
    }
    
    public void printRoundOfGameResult() {
        System.out.println(GAME_RESULT_MESSAGE);
        for (int i = 0; i < numberOfTry; i++) {
            for (Car car : cars) {
                car.goOrStop();
            }
            output = new Output(cars);
            output.printResult();
        }
    }
    public void printFinalWinner() {
        output.printFinalWinner();
    }
}
