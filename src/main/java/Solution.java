import domain.Car;
import domain.InputReport;
import java.util.Vector;

public class Solution {

    public static void main(String[] args) {

        String s;
        String[] sarray;
        Boolean bool;
        Vector<String> names;
        int numberOfRound;
        Vector<Car> cars;

        names = Game.getCarNames();
        numberOfRound = Game.getNumberOfRound();
        cars = Game.generateCarsByNames(names);

        Game.doRace(cars, numberOfRound);


    }

}
