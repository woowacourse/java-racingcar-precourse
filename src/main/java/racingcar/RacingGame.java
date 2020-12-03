package racingcar;

import racingcar.domain.Car;
import racingcar.view.ErrorView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private Scanner scanner;
    private List<Car> carList;
    private int numberOfRaces = 0;

    public RacingGame(Scanner scanner){
        this.scanner = scanner;
    }

    public void runGame(){
        setup();
        startRace();
    }

    private void setup(){
        try {
            InputView.printCarNameInputLog();
            String carNames = scanner.nextLine();
            setupCars(carNames);
        } catch (IllegalArgumentException ie){
            ErrorView.printCarNameInputLogError();
        }
    }

    private void startRace() {
        try {
            InputView.printRaceNumInputLog();
            numberOfRaces = Integer.parseInt(scanner.nextLine());
            printRace();
        } catch (IllegalArgumentException ie){
            ErrorView.printRaceNumInputLogErrorNotNumber();
        }
    }

    private void setupCars(String inputCars){
        String[] cars = inputCars.split(",");
        for(String car : cars){
            checkCarNameLength(car);
        }
        initializeCars(cars);
    }

    private void initializeCars(String[] cars){
        carList = new LinkedList<>(Arrays.stream(cars)
                .map(name -> new Car(name))
                .collect(Collectors.toList()));
    }

    private void checkCarNameLength(String car){
        if(car.length() >= MAX_CAR_NAME_LENGTH)
            throw new IllegalArgumentException();
    }

    private void printRace(){
        OutputView.printRaceStartLog();
        for (int i = 0; i < numberOfRaces; i++) {
            moveCars();
            printCars();
        }
        printWinners();
    }

    private void moveCars(){
        for (Car car : carList) {
            car.move();
        }
    }

    private void printCars(){
        OutputView.printRaceProgressLog(carList);
        System.out.println();
    }

    private void printWinners(){
        OutputView.printWinnerLog(carList);
    }
}
