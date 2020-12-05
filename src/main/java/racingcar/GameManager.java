package racingcar;

import utils.RandomUtils;
import java.util.ArrayList;

public class GameManager {

    public static final boolean INITIALIZATION_BOOLEAN = false;
    public static final int INITIALIZATION_INTEGER = 0;
    public static final String NAMES_CONNECTOR = ", ";

    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int BOUNDARY_OF_TOGGLE = 3;

    private static final String EXECUTION_RESULT = "실행결과";
    private static final String CAR_POSITION_START_POINT = " : ";
    private static final String CAR_POSITION_STATUS_BAR = "-";
    private static final String WINNERS_PREFIX = "최종 우승자: ";

    private int numberOfTry = INITIALIZATION_INTEGER;
    private int winnerPosition = INITIALIZATION_INTEGER;
    private ArrayList<Car> carList = new ArrayList<>();

    public GameManager(String[] names, int numberOfTry) {
        for (String name : names) {
            carList.add(new Car(name));
        }
        this.numberOfTry = numberOfTry;
    }

    public void gameStart() {
        System.out.println("\n" + EXECUTION_RESULT);
        for (int round = 0; round < numberOfTry; round++) {
            playRound();
        }
        printWinners();
    }
    
    public void playRound() {
        for (Car car : carList) {
            if (keepGoing()) {
                car.forwardPosition();
                updateWinnerPosition(car);
            }
        }
        printResultOfRound();
    }

    public boolean keepGoing() {
        int randomNumber = RandomUtils.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        return randomNumber > BOUNDARY_OF_TOGGLE;
    }

    public void printResultOfRound() {
        for (Car car : carList) {
            System.out.print(car.getName() + CAR_POSITION_START_POINT);
            printStatusBar(car);
        }
        System.out.println();
    }

    public void printStatusBar(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(CAR_POSITION_STATUS_BAR);
        }
        System.out.println();
    }

    public void updateWinnerPosition(Car car) {
        if (winnerPosition < car.getPosition()) {
            winnerPosition = car.getPosition();
        }
    }

    public void printWinners() {
        int carListSize = carList.size();
        boolean printedFirstWinner = false;
        System.out.print(WINNERS_PREFIX);
        for (int i = 0; i < carListSize; i++) {
            if (carList.get(i).getPosition() == winnerPosition) {
                printWinnerNames(i, printedFirstWinner);
                printedFirstWinner = true;
            }
        }
    }

    public void printWinnerNames(int index, boolean printedFirstWinner) {
        if (printedFirstWinner) {
            System.out.print(NAMES_CONNECTOR);
        }
        System.out.print(carList.get(index).getName());
    }

}
