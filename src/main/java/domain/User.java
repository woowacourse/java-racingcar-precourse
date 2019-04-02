package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private ArrayList<Car> cars;
    private Scanner sc;
    private int count;
    private final int limitLength = 5;

    public User() {
        sc = new Scanner(System.in);
        cars = new ArrayList<>();
        inputGame();
    }

    private void inputGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String InputCarName[] = sc.next().trim().split(",");
        System.out.println("시도할 횟수는 몇회인가요?");
        count = sc.nextInt();
        for (int i = 0; i < InputCarName.length; i++) {
            if (limitlength(InputCarName[i])) {
                cars.add(new Car(InputCarName[i]));
            }
        }
    }

    private boolean limitlength(String CarName) {
        if (CarName.length() <= limitLength) {
            return true;
        }
        return false;
    }

    public ArrayList<Car> getCar() {
        return cars;
    }

    public int getcount() {
        return count;
    }

}
