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
}
