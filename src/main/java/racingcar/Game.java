package racingcar;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    private ArrayList<String> carNames;
    private ArrayList<Car> carList = new ArrayList<Car>();
    private int round;
    private Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        this.carNames = Input.askCarInfo(this.scanner);
        this.round = Input.askRound(this.scanner);
        ArrayList<String> winnerList;

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
        winnerList = Winner.getWinner(carList);
        System.out.print("최종 우승자: ");
        for (int i = 0; i < winnerList.size(); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(winnerList.get(i));
        }
    }


}
