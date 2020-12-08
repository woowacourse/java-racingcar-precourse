package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Input input;
    private Output output;
    
    private ArrayList<Car> cars = new ArrayList<Car>();
    private int numberOfTry;
    
    public Game(Scanner scanner) {
        input = new Input(scanner);
    }
    
    public void run() {
        inputCarName();
        inputNumberOfTry();
        printRoundOfGameResult();
        printFinalWinner();
    }
    
    public void inputCarName() {
        String[] carNames = input.getCarNames();
        checkCarNameException(carNames);
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }
    public void inputNumberOfTry() {
        numberOfTry = input.getNumberOfTry();
        checkNumberOfTryException(numberOfTry);
        System.out.println();
    }
    
    public void checkCarNameException(String[] carNames) {
        input.checkCarNameLength(carNames);
        input.checkCarNameDuplicate(carNames);
        input.checkCarNameBlankSpace(carNames);
    }
    public void checkNumberOfTryException(int numberOfTry) {
        input.checkNegativeNumber(numberOfTry);
    }
    
    public void printRoundOfGameResult() {
        System.out.println("실행결과");
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
