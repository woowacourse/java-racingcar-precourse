import domain.Car;
import java.util.Collections;
import java.util.Vector;

public class Solution {

    public static void main(String[] args) {
        Vector<String> names;
        int numberOfRound;
        Vector<Car> cars;

        names = Game.getCarNames();
        numberOfRound = Game.getNumberOfRound();
        cars = Game.generateCarsByNames(names);

        Game.doRace(cars, numberOfRound);
        Collections.sort(cars);

        Game.findAndShowChampions(cars);
    }

}
