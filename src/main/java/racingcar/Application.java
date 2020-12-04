package racingcar;

import enums.ErrorMessage;
import enums.GameHost;
import enums.GameProcess;
import maintenance.Mechanic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private Mechanic mechanic;
    private CommandCenter commandCenter;
    private Winner winner;
    private List<Car> carList;

    Application() {
        mechanic = new Mechanic();
        commandCenter = new CommandCenter(mechanic);
        winner = new Winner();
        carList = new ArrayList<>();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Application application = new Application();
        application.playRacingCarGame(scanner);
    }

    private void playRacingCarGame(Scanner scanner) {
        carList = createCarList(scanner);
        Car.setTurnsToTry(commandCenter.inputTurnsToTry(scanner));
        System.out.println();
        System.out.println(GameHost.PROGRESS_RESULT.getMessage());
        while (Car.getTurnsToTry() > GameProcess.NO_TURN.getValue()) {
            showResultOfEachTurn();
        }
        String winnerNames = winner.getWinnerNames(carList);
        System.out.println(GameHost.FINAL_WINNER.getMessage() + winnerNames);
    }

    private List<Car> createCarList(Scanner scanner) {
        String[] namesOfCarsArray = commandCenter.inputNamesOfCars(scanner);
        for (String nameOfCar : namesOfCarsArray) {
            addCarToList(mechanic.getCarWithValidName(nameOfCar));
        }
        mechanic.noticeErrors(namesOfCarsArray , carList);
        if (isCarListEmpty()) {
            noticeEmptyCarList();
            return createCarList(scanner);
        }
        return carList;
    }

    private void addCarToList(Car carWithValidName) {
        if (carWithValidName != null) {
            carList.add(carWithValidName);
        }
    }

    private boolean isCarListEmpty() {
        return carList.size() == 0;
    }

    private void noticeEmptyCarList() {
        System.err.println(ErrorMessage.EMPTY_CAR_LIST.getMessage());
    }

    private void showResultOfEachTurn() {
        for (Car car : carList) {
            printEachTurnOfCar(car);
            System.out.println();
        }
        Car.useOneTurn();
        System.out.println();
    }

    private void printEachTurnOfCar(Car car) {
        car.moveOrStay();
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(GameHost.PROGRESS_BAR.getMessage());
        }
    }
}
