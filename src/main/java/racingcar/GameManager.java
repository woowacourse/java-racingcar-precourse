package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;

public class GameManager {

    public static final int MIN_RANDOM_VALUE = 0;
    public static final int MAX_RANDOM_VALUE = 9;
    public static final int BOUNDARY_OF_TOGGLE = 3;

    private int numberOfTry = 0;
    private int winnerPosition = 0;
    private ArrayList<Car> carList = new ArrayList<>();

    public GameManager(String[] names, int numberOfTry) {
        for (String name : names) {
            carList.add(new Car(name));
        }
        this.numberOfTry = numberOfTry;
    }

    public void gameStart() {
        System.out.println("\n실행결과");
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
            System.out.print(car.getName() + " : ");
            printStatusBar(car);
        }
        System.out.println();
    }

    public void printStatusBar(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
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
        System.out.print("최종 우승자: ");
        for (int i = 0; i < carListSize; i++) {
            if (carList.get(i).getPosition() == winnerPosition) {
                printWinnerNames(i, printedFirstWinner);
                printedFirstWinner = true;
            }
        }
    }

    public void printWinnerNames(int index, boolean printedFirstWinner) {
        if (printedFirstWinner) {
            System.out.print(", ");
        }
        System.out.print(carList.get(index).getName());
    }

}
