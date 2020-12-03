package racingcar;

import enums.ErrorMessage;
import enums.GameHost;
import enums.GameProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    GamePlayer gamePlayer;
    Winner winner;
    List<Car> carList;

    Application() {
        gamePlayer = new GamePlayer();
        winner = new Winner();
        carList = new ArrayList<>();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Application application = new Application();
        application.playRacingCarGame(scanner);
    }

    public void playRacingCarGame(Scanner scanner) {
        carList = createCarList(scanner);
        Car.setTurnsToTry(gamePlayer.inputTurnsToTry(scanner));
        System.out.println();
        System.out.println(GameHost.PROGRESS_RESULT.getMessage());
        while (Car.getTurnsToTry() > GameProcess.NO_TURN.getValue()) {
            showResultOfEachTurn();
        }
        winner.findWinners(carList);
        String winnerNames = winner.getWinnerNames();
        System.out.println(GameHost.FINAL_WINNER.getMessage() + winnerNames);
    }

    public List<Car> createCarList(Scanner scanner) {
        String[] namesOfCarsArray = gamePlayer.inputNamesOfCars(scanner);
        int numberOfTrimmedName = 0;
        for (String nameOfCar : namesOfCarsArray) {
            numberOfTrimmedName += countNumberOfNameWithForeAndAftBlank(nameOfCar);
            addValidNameOfCar(nameOfCar);
        }
        noticeNameTrimmed(numberOfTrimmedName);
        noticeBlankNameRemoved(namesOfCarsArray , carList);
        return carList;
    }

    public int countNumberOfNameWithForeAndAftBlank(String nameOfCar) {
        if (isStartsWithBlank(nameOfCar) || isEndsWithBlank(nameOfCar)) {
            return 1;
        }
        return 0;
    }

    public boolean isStartsWithBlank(String nameOfCar) {
        return nameOfCar.startsWith(" ");
    }

    public boolean isEndsWithBlank(String nameOfCar) {
        return nameOfCar.endsWith(" ");
    }

    public void addValidNameOfCar(String nameOfCar) {
        nameOfCar = shortenNameLengthToMax(nameOfCar.trim());
        if (isNameBlank(nameOfCar)) {
            return;
        }
        Car car = new Car(nameOfCar.trim());
        carList.add(car);
    }

    public String shortenNameLengthToMax(String nameOfCar) {
        if (isNameLengthOverMax(nameOfCar)) {
            System.err.println(ErrorMessage.OVER_MAXIMUM_NAME_LENGTH.getMessage());
            return nameOfCar.substring(0, GameProcess.MAXIMUM_NAME_LENGTH.getValue());
        }
        return nameOfCar;
    }

    public boolean isNameLengthOverMax(String nameOfCar) {
        return nameOfCar.length() > GameProcess.MAXIMUM_NAME_LENGTH.getValue();
    }

    public boolean isNameBlank(String nameOfCar) {
        return nameOfCar.equals("");
    }

    public void noticeNameTrimmed(int numberOfTrimmedName) {
        if (numberOfTrimmedName > 0) {
            System.err.println(ErrorMessage.NAME_WITH_FORE_AND_AFT_BLANK.getMessage());
        }
    }

    public void noticeBlankNameRemoved(String[] namesOfCarsArray, List<Car> carList) {
        if (isBlankNameInputted(namesOfCarsArray, carList)) {
            System.err.println(ErrorMessage.BLANK_NAME.getMessage());
        }
    }

    public boolean isBlankNameInputted(String[] namesOfCarsArray, List<Car> carList) {
        return namesOfCarsArray.length != carList.size();
    }

    public void showResultOfEachTurn() {
        for (Car car : carList) {
            printEachTurnOfCar(car);
            System.out.println();
        }
        Car.useOneTurn();
        System.out.println();
    }

    public void printEachTurnOfCar(Car car) {
        car.moveOrStay();
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(GameHost.PROGRESS_BAR.getMessage());
        }
    }
}
