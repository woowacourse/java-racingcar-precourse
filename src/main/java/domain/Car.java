package domain;

import java.util.*;

public class Car {
    private final String name;
    private static int times;
    private static List<Car> carList;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    static public void enterCarName() {
        String carName[];
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        /* 쉼표로 구분 된 이름들을 carList에 추가 */
        carName = scan.nextLine().split(",");
        carList = new ArrayList<>();
        for (String token  :carName) {
            carList.add(new Car(token));
        }
    }

    static public void enterHowManyTime() {
        Scanner scan = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        times = scan.nextInt();
    }
    public void printNameAndPosition() {
        System.out.print(name+":");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    static public void printRacingResult() {
        System.out.println("실행 결과");
        /* 실행 */

        for (Car c  : carList) {
            c.printNameAndPosition();
        }
    }

    static public void printWinner() {
        /* 우승자 판단 */

        System.out.println("가 최종 우승했습니다.");
    }


    public static void main(String[] args) {
        Car.enterCarName();
        Car.enterHowManyTime();
        Car.printRacingResult();
        Car.printWinner();
    }

    // 추가 기능 구현
}
