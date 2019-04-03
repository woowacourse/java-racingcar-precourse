import java.util.Vector;

public class Game {
    private static final String SEPERATOR = ",";
    private static final int MAX = 5;
    private static final String FIRST_WORD = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SECOND_WORD = "시도할 횟수는 몇회인가요?";

    static Vector<String> getCarNames() {
        String input;
        Vector<String> names;

        while(true) {
            input = InputHandler.getInput(FIRST_WORD);
            names = InputHandler.parse(input, SEPERATOR);
            if(!Oracle.checkFaultyInput(names, MAX)) {
                break;
            }
        }

        return names;
    }
    /*
    static int getRoundNumber() {
        String input;

        while(true) {
            try {

            }
        }
    }
    */

}
