import domain.Car;
import domain.InputReport;
import java.util.Vector;

public class Solution {

    public static void main(String[] args) {

        String s;
        String[] sarray;
        Boolean bool;
        Vector<String> names;
        int count;
        Vector<Car> cars;
        int falseNum = 0;
        int trueNum = 0;

        InputReport error;

        names = Game.getCarNames();
        count = Game.getNumberOfRound();
        System.out.println(count);
        cars = Game.generateCarsByNames(names);
        /*
        Oracle.drawCharacters(10,'*');
        Oracle.drawCharacters(10,'-');
        */



    }

}
