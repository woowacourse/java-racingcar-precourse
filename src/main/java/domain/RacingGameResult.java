package domain;

import java.util.ArrayList;

public class RacingGameResult {
    private ArrayList<Car> cars;
    private int positionOfWinners;
    private ArrayList<Car> winners = new ArrayList<>();

    public RacingGameResult(ArrayList<Car> cars, int positionOfWinners) {
        this.cars = cars;
        this.positionOfWinners = positionOfWinners;

        classifyWinners();
    }

    public void classifyWinners() {
        for (Car car : cars) {
            if (car.getPosition() == positionOfWinners) {
                winners.add(car);
            }
        }
    }

    public void show() {
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("(이)가 최종 우승했습니다.");
    }
}
