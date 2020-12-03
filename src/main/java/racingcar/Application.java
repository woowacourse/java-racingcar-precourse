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
        Car.setTurnsToTry(gamePlayer.inputTurnsToTry(scanner));
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
                System.out.print("-");
            }
            System.out.println();
        }
        Car.useOneTurn();
        System.out.println();
    }

    public String getCorrectName(String nameOfCar) {
        if (isNameLengthOver5(nameOfCar)) {
            System.err.println("[ERROR] 이름은 5자까지 출력됩니다.");
            return nameOfCar.substring(0, 5);
        }
        return nameOfCar;
    }

    public boolean isNameLengthOver5(String nameOfCar) {
        return nameOfCar.length() > 5;
    }

    public boolean isNameBlank(String nameOfCar) {
        return nameOfCar.equals("");
    }

    public void noticeBlankNameRemoved(String[] namesOfCarsArray, List<Car> carList) {
        if (isBlankNameInputted(namesOfCarsArray, carList)) {
            System.err.println("[ERROR] 이름이 공백인 경우 미입력 처리됩니다.");
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
            System.err.println("[ERROR] 이름 앞, 뒤의 공백은 제거됩니다.");
        }
    }
}
