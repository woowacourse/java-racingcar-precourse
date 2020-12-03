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
        System.out.println(GameHost.PROGRESS_RESULT);
        while (Car.getTurnsToTry() > GameProcess.NO_TURN.getValue()) {
            showResultOfEachTurn();
        }
        winner.findWinners(carList);
        String winnerNames = winner.getWinnerNames();
        System.out.println(GameHost.FINAL_WINNER + winnerNames);
    }

    public List<Car> createCarList(Scanner scanner) {
        String[] namesOfCarsArray = gamePlayer.inputNamesOfCars(scanner);
        List<Car> carList = new ArrayList<>();
        int numberOfTrimmedName = 0;
        for (String nameOfCar : namesOfCarsArray) {
            numberOfTrimmedName += countNameWithForeAndAftBlank(nameOfCar);
            nameOfCar = getCorrectName(nameOfCar.trim());
            if (isNameBlank(nameOfCar)) {
                continue;
            }
            Car car = new Car(nameOfCar.trim());
            carList.add(car);
        }
        noticeNameTrimmed(numberOfTrimmedName);
        noticeBlankNameRemoved(namesOfCarsArray , carList);
        return carList;
    }

    public void showResultOfEachTurn() {
        for (Car car : carList) {
            car.moveOrStay();
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print(GameHost.PROGRESS_BAR.getMessage());
            }
            System.out.println();
        }
        Car.useOneTurn();
        System.out.println();
    }

    public String getCorrectName(String nameOfCar) {
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

    public void noticeBlankNameRemoved(String[] namesOfCarsArray, List<Car> carList) {
        if (isBlankNameInputted(namesOfCarsArray, carList)) {
            System.err.println(ErrorMessage.BLANK_NAME.getMessage());
        }
    }

    public boolean isBlankNameInputted(String[] namesOfCarsArray, List<Car> carList) {
        return namesOfCarsArray.length != carList.size();
    }

    public int countNameWithForeAndAftBlank(String nameOfCar) {
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

    public void noticeNameTrimmed(int numberOfTrimmedName) {
        if (numberOfTrimmedName > 0) {
            System.err.println(ErrorMessage.NAME_WITH_FORE_AND_AFT_BLANK.getMessage());
        }
    }
}
