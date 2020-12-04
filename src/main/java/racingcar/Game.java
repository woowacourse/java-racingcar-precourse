package racingcar;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    private ArrayList<String> carNames;
    private ArrayList<Car> carList = new ArrayList<Car>();
    private int round = 5;

    public Game() {
    }
    public void startGame(Scanner scanner) {
        this.carNames = AskCarInfo.askCarInfo(scanner);
        for (int i = 0; i< carNames.size(); i++) {
            carList.add(new Car(carNames.get(i)));
        }
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            carList.forEach(car -> {
                car.move();
                car.printPosition();
            });
            System.out.println();
        }
    }


}
