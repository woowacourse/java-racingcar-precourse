package racingcar;

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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carList = createCarList(scanner);
        System.out.println("시도할 횟수는 몇회인가요?");
        Car.setTurnsToTry(gamePlayer.inputTimesToTry(scanner));
        System.out.println();
        System.out.println("실행 결과");
        while (Car.getTurnsToTry() > 0) {
            showResultOfEachTurn();
        }
        winner.findWinners(carList);
        String winnerNames = winner.getWinnerNames();
        System.out.println("최종 우승자: " + winnerNames);
    }

    public List<Car> createCarList(Scanner scanner) {
        String[] namesOfCarsArray = gamePlayer.inputNamesOfCars(scanner);
        List<Car> carList = new ArrayList<>();
        for (String nameOfCar : namesOfCarsArray) {
            nameOfCar = getCorrectName(nameOfCar.trim());
            Car car = new Car(nameOfCar);
            carList.add(car);
        }
        return carList;
    }

    public void showResultOfEachTurn() {
        for (Car car : carList) {
            car.moveOrStay();
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        Car.useOneTurn();
        System.out.println();
    }

    public String getCorrectName(String nameOfCar) {
        if (isNameLengthOver5(nameOfCar)) {
            return nameOfCar.substring(0, 5);
        }
        return nameOfCar;
    }

    public boolean isNameLengthOver5(String nameOfCar) {
        return nameOfCar.length() > 5;
    }
}
