package domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    private Car[] cars;
    private Display display;

    public Game() {
        display = new Display();
    }

    public Car[] makeCars(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

    public void goOneTurnForEachCar() {
        for (int i = 0; i < cars.length; i++) {
            int randomNum = cars[i].makeRandomNums();
            cars[i].increasePosition(randomNum);
            display.showResults(cars[i]);
        }
    }

    public void decidesWinner() {
        int maxPosition = cars[0].getPosition();
        ArrayList<String> ans = new ArrayList<String>();
        ans.add(cars[0].getName());
        for (int i = 1; i < cars.length; i++) {
            if (maxPosition != cars[i].getPosition()) {
                break;
            }
            ans.add(cars[i].getName());
        }
        display.showWinners(ans);
    }
}
