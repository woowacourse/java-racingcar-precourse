package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.inputMessage;

public class inputView {

    public String[] getNames() {
        out(inputMessage.START_GAME);
        String inputname = Console.readLine();
        String[] names = inputname.split(",");
        try{
            nameRange(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getNames();
        }
        return names;
    }

    private void nameRange(String[] names) {
        for(String name : names) {
            if(name.length()>5){
                throw new IllegalArgumentException("[ERROR] 이름은 다섯 글자를 넘길 수 없다.");
            }
        }
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
