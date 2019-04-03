import java.util.Vector;

public class Game {
    private static final String SEPERATOR = ",";
    private static final int MAX = 5;

    static Vector<String> getCarNames() {
        String input;
        Vector<String> names;

        while(true) {
            input = InputHandler.getFirstInput();
            names = InputHandler.parse(input, SEPERATOR);
            if(!Oracle.checkFaultyInput(names, MAX)) {
                break;
            }
        }

        return names;
    }


}
