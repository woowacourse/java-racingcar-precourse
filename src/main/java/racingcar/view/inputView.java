package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.inputMessage;

public class inputView {

    public String[] getNames() {
        out(inputMessage.START_GAME);
        String inputname = Console.readLine();
        String[] names = inputname.split(",");
        return names;
    }

    public int getRound() {
        out(inputMessage.GET_GAME_ROUND);
        String inputround = Console.readLine();
        int round = Integer.parseInt(inputround);
        return round;
    }

    private void out(String text) {
        System.out.println(text);
    }

}
