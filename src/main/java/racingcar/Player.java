package racingcar;

import constants.SystemMessage;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public static List<String> getCarName() {
        List<String> parsedCarName = new ArrayList<String>();
        while(true){
            try{
                parsedCarName = Utils.getCarName();
                break;
            } catch (IllegalArgumentException e){
                System.out.println(SystemMessage.ERROR_INVALID_CARNAME);
            }
        }
        return parsedCarName;
    }

    public static int getTurnNumber(){
        int turn = 0;
        while(true){
            try{
                turn = Utils.getTurnNumber();
                break;
            } catch (IllegalArgumentException e){
                System.out.println(SystemMessage.ERROR_INVALID_CARNUMBER);
            }
        }
        return turn;
    }

}
