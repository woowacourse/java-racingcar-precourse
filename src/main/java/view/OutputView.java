package view;

import domain.Car;

public class OutputView {

    public void printResultForOneGame(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + repeat("-", car.getPosition()));
        }
    }

    private String repeat(String target, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(target);
        }
        return sb.toString();
    }
}
