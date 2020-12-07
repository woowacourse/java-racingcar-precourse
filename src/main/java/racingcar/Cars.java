package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    private int winnerMove;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        winnerMove = 0;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public int size() {
        return cars.size();
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public void printCarStatus() {
        cars.stream()
                .forEach(car -> {
                    String positionToString = "";
                    for (int positionCount = 0; positionCount < car.getPosition(); positionCount++) {
                        positionToString += "-";
                    }
                    System.out.println(car.getCarName() + " : " + positionToString);
                });
        System.out.println();
    }

    public void printWinners() {
        findWinCount();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자: ");
        for (int carIndex = 0; carIndex < cars.size(); carIndex++) {
            Car nowCar = cars.get(carIndex);
            if (nowCar.getPosition() == this.winnerMove) {
                stringBuilder.append(nowCar.getCarName());
                stringBuilder.append(", ");
            }
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1);
        System.out.println(stringBuilder.toString());
    }

    private void findWinCount() {
        for (int carIndex = 0; carIndex < cars.size(); carIndex++) {
            Car nowCar = cars.get(carIndex);
            this.winnerMove = Math.max(this.winnerMove, nowCar.getPosition());
        }
    }
}
