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

        for(int i = 0; i < 1000; i++) {
            bool = Oracle.tellGoOrStop(9,0,4);
            if(bool) trueNum++;
            if(!bool) falseNum++;
        }

        System.out.print("trueNum: ");
        System.out.println(trueNum);
        System.out.print("falseNum: ");
        System.out.println(falseNum);




    }

}
