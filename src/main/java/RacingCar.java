/**
 * class : RacingCar.java
 * <p>
 * version : 1.0
 * <p>
 * date : 2019.04.01
 * <p>
 * author : icarus8050
 */

import domain.Car;
import racing.CarListMaker;
import racing.InputValidation;

import java.util.List;
import java.util.Scanner;

/**
 * 레이싱 게임을 진행하는 메인 클래스
 */
public class RacingCar {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        List<Car> carList = CarListMaker.getList(inputCarList());
        int rumTime = inputRumTimeNumber();

        startRacing(carList, rumTime);
        printFirstCarList(carList);

        scanner.close();
    }

    /**
     * 경주할 자동차 이름 목록을 입력하는 메소드
     *
     * @return ","로 구분된 자동차 이름 목록
     */
    private static String inputCarList() {
        String stringBasedCarList;

        /* 유효한 자동차 이름 리스트를 입력될 때까지 루프 순회 */
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            stringBasedCarList = scanner.nextLine();
            if (InputValidation.inspectCarNames(stringBasedCarList)) {
                return stringBasedCarList;
            }
        }
    }

    private static int inputRumTimeNumber() {
        String input;

        /* 유효한 시도 횟수가 입력될 때까지 루프 순회 */
        while (true) {
            System.out.println("시도할 횟수는 몇회인가요?");
            input = scanner.nextLine();
            if (InputValidation.inspectRuntimeNumber(input)) {
                System.out.println();
                return Integer.parseInt(input);
            }
        }
    }

    private static void startRacing(List<Car> carList, int runTime) {
        System.out.println("실행 결과");
        while (runTime-- > 0) {
            carList.forEach(car -> {
                car.move();
                car.printPosition();
            });
            System.out.println();
        }
    }

    private static void printFirstCarList(List<Car> carList) {
        int mostDistance = getMostDistance(carList);
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : carList) {
            if (car.getPosition() == mostDistance) {
                stringBuilder.append(car.getName()).append(", ");
            }
        }

        /* 마지막에 추가된 ", "를 제거하기 위한 코드 */
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        System.out.println(stringBuilder + "가 최종 우승했습니다.");
    }

    private static int getMostDistance(List<Car> carList) {
        return carList.stream()
                .max((car_1, car_2) -> Integer.compare(car_1.getPosition(), car_2.getPosition()))
                .get()
                .getPosition();
    }
}
