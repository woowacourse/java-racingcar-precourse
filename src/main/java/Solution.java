import domain.Car;
import domain.InputReport;

import java.util.Collections;
import java.util.Vector;

public class Solution {

    public static void main(String[] args) {

        Vector<String> names;
        int numberOfRound, count;
        Vector<Car> cars, champions;

        names = Game.getCarNames();
        numberOfRound = Game.getNumberOfRound();
        cars = Game.generateCarsByNames(names);

        Game.doRace(cars, numberOfRound);
        Collections.sort(cars);


        champions = Oracle.findChampions(cars);
        for (Car car : champions
             ) {
            System.out.print("champion: ");
            System.out.println(car);
        }
    }

}
