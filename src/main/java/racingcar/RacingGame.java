package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private String[] carNames;
    private String numberOfTimes;
    private Scanner scanner;

    private final List<Car> carList = new ArrayList<>();

    public void playGame(Scanner scanner) {
        this.scanner = scanner;
        getCarNames();
        getNumberOfTimes();
        printResultRacing();
        printBestCarNames();
    }

    private void getCarNames() {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            this.carNames = this.scanner.nextLine().split(",");
            if (InputError.checkInputCarNames(this.carNames)) {
                break;
            }
        }
        makeCarList();
    }

    private void makeCarList() {
        for (String carName : this.carNames) {
            this.carList.add(new Car(carName));
        }
    }

    private void sortCarList() {
        this.carList.sort((o1, o2) -> o2.getPosition() - o1.getPosition());
    }

    private void getNumberOfTimes() {
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            this.numberOfTimes = this.scanner.nextLine();
            if (InputError.checkInputNumber(this.numberOfTimes)) {
                break;
            }
        }
        System.out.println();
    }

    private void printResultRacing() {
        for (int round = 0; round < Integer.parseInt(numberOfTimes); round++) {
            System.out.println("실행 결과");
            for (Car car : carList) {
                car.tryMove();
                System.out.println(car.toString());
            }
            System.out.println();
        }
    }

    private void printBestCarNames() {
        sortCarList();
        StringBuilder sb = new StringBuilder("최종 우승자: ");
        int bestPosition = this.carList.get(0).getPosition();
        for (Car car : this.carList) {
            if (car.getPosition() == bestPosition) {
                sb.append(car.getName()).append(", ");
            }
        }
        System.out.println(sb.substring(0, sb.length() - 2));
    }
}
