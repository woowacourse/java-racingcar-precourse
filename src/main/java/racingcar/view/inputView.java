package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.inputMessage;

import java.util.List;

public class inputView {

    public String[] getNames() {
        out(inputMessage.START_GAME);
        String names = Console.readLine();
        return names.split(",");
    }

    public int getRound() {
        out(inputMessage.GET_GAME_ROUND);
        String round = Console.readLine();
        return Integer.parseInt(round);
    }

    private void out(String text) {
        System.out.println(text);
    }

}
