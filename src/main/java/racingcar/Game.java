package racingcar;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    private ArrayList<String> carNames;
    private ArrayList<Car> carList = new ArrayList<Car>();
    private int round;

    public Game() {
    }

    public void startGame(Scanner scanner) {
        this.carNames = Input.askCarInfo(scanner);
        this.round = Input.askRound(scanner);

        for (int i = 0; i < carNames.size(); i++) {
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
