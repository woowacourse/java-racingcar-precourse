import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    public void Print(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void PrintWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt((car) -> car.getPosition())
                .reduce(-1, (a, b) -> Math.max(a, b));

        ArrayList<String> winnerNames = new ArrayList();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerNames.add(car.getName());
            }
        }

        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}
