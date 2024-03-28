package racingcar;

import java.util.List;
import java.util.stream.Collectors;

// 결과를 보여주는 클래스
public class OutputView {

    public static void outputCarStatus(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void outputWinner(List<Car> carList) {
        int maxPosition = carList.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<Car> winners = carList.stream().filter(car -> car.getPosition() == maxPosition).toList();

        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println("우승자: " + winnerNames);
    }
}
