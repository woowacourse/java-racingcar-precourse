package racingcar;

import java.util.ArrayList;

public class OutputView {
    public static void printRacingStatus(Cars cars) {
        ArrayList<Integer> carsPositions = cars.getCarsPosition();
        ArrayList<String> carsNames = cars.getCarsName();
        for (int i = 0; i < carsNames.size(); i++) {
            System.out.print(carsNames.get(i) + " : ");
            for (int j = 0; j < carsPositions.get(i); j++) {
                System.out.print("-");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void printResult(Cars cars) {
        System.out.print("최종 우승자: ");
        for (int i = 0; i < cars.getCars().size(); i++) {
            System.out.print(cars.getCars().get(i).getName());
            if (i != cars.getCars().size() - 1) {
                System.out.print(",");
            }
        }
    }
}
