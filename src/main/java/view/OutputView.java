package view;

import domain.car.Car;
import domain.car.RacingCars;
import domain.car.WinningCars;

public class OutputView {
    private static final String POSITION = "-";

    public static void showRacingCars(RacingCars racingCars) {
        for (Car car : racingCars.getCars()) {
            String name = car.getName();
            String position = makePosition(car.getPosition());
            System.out.println(String.format("%s : %s", name, position));
        }
        System.out.println();
    }

    private static String makePosition(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(POSITION);
        }
        return sb.toString();
    }

    public static void showWinners(WinningCars winningCars) {
        String names = String.join(", ", winningCars.getWinnersName());
        System.out.println(String.format("%s가 최종 우승하였습니다.", names));
    }
}