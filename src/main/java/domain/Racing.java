/*
 * Racing
 *
 * version 1.5
 *
 * 2019/04/02
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 자동차 경주를 진행할 수 있는 클래스
 *
 * @author 김성훈
 * @version 1.0 2019/04/02  사용자로부터 자동차 이름, 이동 회수를 입력 받는 메소드 구현 / 입력받은 자동차 이름으로 객체 생성
 *          1.1 2019/04/02  입력받은 자동차 이름에 빈칸 제거 / 이름 길이에 오류가 난 경우 다시 입력 받게 처리
 *          1.2 2019/04/02  자동차들중에서 제일 큰 position 값을 구하는 메소드 구현 / 시도할 회수를 받는 메소드 재 구현
 *          1.3 2019/04/02  우승자를 계산하는 메소드 구현
 *          1.4 2019/04/02  경주중인 모든 자동차가 난수에 의해 이동하는 메소드 구현 / 우승자 출력 메소드 구현
 *          1.5 2019/04/02  이동 회수에 숫자 외의 값이 입력됐을 때 다시 입력을 받는 메소드 구현
 */
public class Racing {
    private static Scanner sc = new Scanner(System.in);

    public String[] inputCarName() {
        String[] carNames;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = sc.nextLine().replaceAll(" ", "").split(",");
        } while (hasCarNameException(carNames));

        return carNames;
    }

    public boolean hasCarNameException(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() == 0 || carName.length() > 5) {
                System.out.println("자동차 이름이 잘못된 형식으로 입력됐습니다");
                return true;
            }
        }

        return false;
    }

    public List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public int inputRound() {
        String round = "";

        do {
            System.out.println("시도할 회수는 몇회인가요?");
            round = sc.nextLine();
        } while (!isNumber(round));

        return Integer.parseInt(round);
    }

    public boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력 가능합니다.");
            return false;
        }
    }

    public void moveAllCarsOnRace(List<Car> cars) {
        for (Car car : cars) {
            car.moveCar(car.makeRandomNumber());
            car.printTotalDistance();
        }
        System.out.println();
    }

    public int calcMaximumPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        return max;
    }

    public String calcWinners(List<Car> cars) {
        StringBuilder winners = new StringBuilder();
        int max = calcMaximumPosition(cars);

        for (Car car : cars) {
            if (max == car.getPosition()) {
                winners.append(car.getName() + ", ");
            }
        }
        return winners.toString().substring(0, winners.length() - 2);
    }

    public void printWinners(String winners) {
        System.out.println(winners + "가(이) 최종 우승했습니다.");
    }
}
