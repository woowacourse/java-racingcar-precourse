package communicate;

import java.util.ArrayList;

import racingcar.Car;

public class OutputManager {
    private static final int ZERO = 0;

    public void printCarsInformation(Car car) {
        System.out.println(car.provideInformation());
    }

    public void printWinner(ArrayList<Car> winners) {
        System.out.print(Text.FINAL_WINNER + Text.COLON);

        System.out.print(winners.get(ZERO).getName());

        for (int i = 1; i < winners.size(); i++) {
            System.out.print(Text.SEPARATOR_COMMA_WITH_SPACE + winners.get(i).getName());
        }

    }
}
