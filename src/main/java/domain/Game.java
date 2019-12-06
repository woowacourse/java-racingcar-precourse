package domain;

import java.util.Scanner;

public class Game {
    private Car[] cars;
    private int race;

    public void runGame() {
        this.gameSetting();
    }

    /* 게임을 세팅해주는 부분 */
    public void gameSetting() {
        Scanner sc = new Scanner(System.in);
        this.setNames(sc);
        this.setRaceNumber(sc);
        System.out.println();
    }

    public void setNames(Scanner sc) {
        String[] carNames = {};
        while (true) {
            System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNamesInput = sc.nextLine();
            carNames = carNamesInput.split(",");
            if (isNameLimitSatisfied(carNames) == true) break;
            System.out.println("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        }
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        this.cars = cars;
    }

    public boolean isNameLimitSatisfied(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() >= 6 || carNames[i].length() == 0) {
                return false;
            }
        }
        return true;
    }

    public void setRaceNumber(Scanner sc) {
        int race = 0;
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            race = sc.nextInt();
            if (race != 0) break;
            System.out.println("시도할 회수는 1회 이상만 가능합니다.");
        }
        this.race = race;
    }
}
