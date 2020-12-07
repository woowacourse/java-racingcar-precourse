package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private String[] carNames;
    private String numberOfTimes;

    public void playGame(Scanner scanner) {

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = scanner.nextLine().split(",");

            if (InputError.checkInputCarNames(carNames)) {
                break;
            }
        }

        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            numberOfTimes = scanner.nextLine();
            if (InputError.checkInputNumber(numberOfTimes)) {
                break;
            }
        }
        System.out.println();

        for (int round = 0; round < Integer.parseInt(numberOfTimes); round++) {
            System.out.println("실행 결과");
            for (Car car : carList) {
                car.tryMove();
                System.out.println(car.toString());
            }
            System.out.println();
        }
        carList = sortCarList(carList);
        StringBuilder sb = new StringBuilder("최종 우승자: ");
        int bestPosition = carList.get(0).getPosition();
        for (Car car : carList) {
            if (car.getPosition() == bestPosition) {
                sb.append(car.getName() + ", ");
            }
        }
        System.out.println(sb.substring(0, sb.length() - 2));
    }

    private List<Car> sortCarList(List<Car> carList) {
        carList.sort((o1, o2) -> o2.getPosition() - o1.getPosition());
        return carList;
    }
}
