import java.util.Vector;

public class Oracle {

    static boolean checkLength(Vector<String> names, int MAX) {
        boolean flag = true;

        for (String name : names
        ) {
            if(name.length() > MAX) {
                flag = false;
            }
        }

        return flag;
    }

    static boolean checkRepeatedName(String specificName, Vector<String> names) {
        boolean repetition = false;
        int count;

        count = InputHandler.countName(specificName, names);
        if(count > 1) {
            repetition = true;
        }

        return repetition;
    }
}
