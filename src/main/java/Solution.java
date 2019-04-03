import domain.Car;
import domain.InputReport;

import java.util.Collections;
import java.util.Vector;

public class Solution {

    public static void main(String[] args) {

        Vector<String> names;
        int numberOfRound, count;
        Vector<Car> cars;

        names = Game.getCarNames();
        numberOfRound = Game.getNumberOfRound();
        cars = Game.generateCarsByNames(names);

        Game.doRace(cars, numberOfRound);
        Collections.sort(cars);
        for (Car car : cars
             ) {
            System.out.println(car);
        }

        count = Oracle.numberOfChapmionsAtSortedCarArray(cars);
        System.out.println(count);
    }

}
