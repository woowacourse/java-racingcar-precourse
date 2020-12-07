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

            if (!haveBlankCarName() && isValidSizeCarName() && !isDuplicateName()) {
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
            if (isInteger() && isPositiveNumber()) {
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

    private boolean haveBlankCarName() {
        for (String carName : carNames) {
            if (carName.contains(" ")) {
                System.out.println("[ERROR] 자동차 이름에 공백은 사용이 불가능합니다.");
                return true;
            }
        }
        return false;
    }

    private boolean isValidSizeCarName() {
        for (String carName : carNames) {
            if (carName.length() <= 0 || carName.length() > 5) {
                System.out.println("[ERROR] 자동차 이름은 1자이상 5자이하만 가능합니다.");
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicateName() {
        List<String> carList = new ArrayList<>();

        for (String carName : carNames) {
            if (!carList.contains(carName)) {
                carList.add(carName);
            }
        }

        if (carList.size() != carNames.length) {
            System.out.println("[ERROR] 자동차 이름은 중복이 불가능합니다.");
            return true;
        }

        return false;
    }

    private boolean isInteger() {
        try {
            Integer.parseInt(numberOfTimes);
        } catch (NumberFormatException ne) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다. (입력가능범위 : 1 ~ 2147483647)");
            return false;
        }
        return true;
    }

    private boolean isPositiveNumber() {
        if (Integer.parseInt(numberOfTimes) < 1) {
            System.out.println("[ERROR] 시도 횟수는 1이상의 양수여야 한다. (입력가능범위 : 1 ~ 2147483647)");
            return false;
        }
        return true;
    }

    private List<Car> sortCarList(List<Car> carList) {
        carList.sort((o1, o2) -> o2.getPosition() - o1.getPosition());
        return carList;
    }
}
