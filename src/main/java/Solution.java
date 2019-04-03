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
        int falseNum = 0;
        int trueNum = 0;

        InputReport error;

        names = Game.getCarNames();
        numberOfRound = Game.getNumberOfRound();
        System.out.println(numberOfRound);
        cars = Game.generateCarsByNames(names);

        Game.doRace(cars, numberOfRound);


    }

}
