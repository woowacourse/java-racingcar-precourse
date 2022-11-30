package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.exceptionMessage;
import racingcar.message.inputMessage;

import java.util.ArrayList;
import java.util.List;

public class inputView {

    public String[] getNames() {
        out(inputMessage.START_GAME);
        String inputname = Console.readLine();
        String[] names = inputname.split(",");
        try{
            nameRange(names);
            sameName(names);
        } catch (IllegalArgumentException e) {
            getNames();
        }
        return names;
    }

    private void nameRange(String[] names) {
        for(String name : names) {
            if(name.length()>5){
                out(exceptionMessage.CAR_NAME_RANGE);
                throw new IllegalArgumentException();
            }
        }
    }

    private void sameName(String[] names) {
        List<String> check = new ArrayList<>();
        for(String name : names) {
            if(check.contains(name)){
                out(exceptionMessage.SAME_NAME);
                throw new IllegalArgumentException();
            } else {
                check.add(name);
            }
        }
    }

    public int getRound() {
        out(inputMessage.GET_GAME_ROUND);
        String inputround = Console.readLine();
        int round = 0;
        try{
            round = Integer.parseInt(inputround);
        } catch (IllegalArgumentException e) {
            out(exceptionMessage.ROUND_STIRNG);
            getRound();
        }
        return round;
    }

    private void out(String text) {
        System.out.println(text);
    }

}
