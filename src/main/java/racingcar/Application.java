package racingcar;

import enums.GameHost;
import enums.GameProcess;
import maintenance.Mechanic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    GamePlayer gamePlayer;
    Mechanic mechanic;
    Winner winner;
    List<Car> carList;

    Application() {
        gamePlayer = new GamePlayer();
        mechanic = new Mechanic();
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
        int numberOfTrimmedNames = 0;
        int numberOfNamesOverMaxLength = 0;
        for (String nameOfCar : namesOfCarsArray) {
            nameOfCar = nameOfCar.trim();
            numberOfTrimmedNames += mechanic.countNumberOfNamesWithForeAndAftBlank(nameOfCar);
            numberOfNamesOverMaxLength += mechanic.countNumberOfNamesOverMaxLength(nameOfCar);
            addCarToList(mechanic.getCarWithValidName(nameOfCar));
        }
        mechanic.noticeShortenName(numberOfNamesOverMaxLength);
        mechanic.noticeNameTrimmed(numberOfTrimmedNames);
        mechanic.noticeBlankNameRemoved(namesOfCarsArray , carList);
        return carList;
    }

    public void addCarToList(Car carWithValidName) {
        if (carWithValidName != null) {
            carList.add(carWithValidName);
        }
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
