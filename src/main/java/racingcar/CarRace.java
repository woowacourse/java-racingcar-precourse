package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private List<Car> racingCars;
    private List<Car> winnerCars;

    public CarRace(String carName) {
        racingCars = new ArrayList<>();

        String[] carNames = carName.replace(" ", "").split(",");
        for (String s : carNames) {
            racingCars.add(new Car(s));
        }
    }

    public void doRace(int raceNumber) {
        for (int i = 0; i < raceNumber; i++) {
            for (Car c : racingCars) {
                c.move();
                printRace(c);
            }
            System.out.println();
        }
        addWinnerToList();
        printWinner();
    }

    public static void printRace(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void addWinnerToList() {
        winnerCars = new ArrayList<>();

        int winnerPosition = 0;
        for (Car c : racingCars) {
            if (c.getPosition() > winnerPosition) {
                winnerPosition = c.getPosition();
            }
        }
        for (Car c : racingCars) {
            if (c.getPosition() >= winnerPosition) {
                winnerCars.add(c);
            }
        }
    }

    public void printWinner() {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerCars.size(); i++) {
            if (i == 0) {
                System.out.print(winnerCars.get(i).getName());
            }
            if (i != 0) {
                System.out.print(", " + winnerCars.get(i).getName());
            }
        }
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public List<Car> getWinnerCars() {
        return winnerCars;
    }
}
