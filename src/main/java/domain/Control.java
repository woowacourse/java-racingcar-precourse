package domain;

import java.util.Scanner;
import java.util.ArrayList;

public class Control {
    Scanner sc = new Scanner(System.in);
    ArrayList<Car> cars = new ArrayList<Car>();
    int limitN = 0;

    public void userInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carNames = sc.nextLine();
        setCar(carNames);
    }

    public void setCar(String str) {
        String[] carArray = str.split(",");

        for (int i = 0; i < carArray.length; i++) {
            this.cars.add(new Car(carArray[i], 0));
        }
    }

    public void userInputLimitTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        this.limitN = sc.nextInt();
    }

    public void gameStart() {

    }

    public void gameEnd() {

    }
}