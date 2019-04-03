import domain.InputReport;
import java.util.Vector;

public class Solution {

    public static void main(String[] args) {

        String s;
        String[] sarray;
        Boolean bool;
        Vector<String> vector;
        int count;
        Vector<InputReport> reports;
        InputReport error;

        vector = Game.getCarNames();
        for (String name : vector
             ) {
            System.out.println(name);
        }


    }

}
