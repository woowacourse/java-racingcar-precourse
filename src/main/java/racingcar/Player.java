package racingcar;

import camp.nextstep.edu.missionutils.Console;
import constants.SystemMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    public static List<String> getCarName() {
        List<String> parsedCarName = new ArrayList<String>();
        while(true){
            try{
                parsedCarName = getName();
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
                turn = getNumber();
                break;
            } catch (IllegalArgumentException e){
                System.out.println(SystemMessage.ERROR_INVALID_CARNUMBER);
            }
        }
        return turn;
    }

    public static List<String> getName(){
        System.out.println(SystemMessage.INPUT_CARNAME);
        String carName = Console.readLine();
        List<String> parsedCarName = parseCarName(carName);
        return parsedCarName;
    }

    private static List<String> parseCarName(String carName) {
        String[] parsedArrCarName = carName.split(",");
        List<String> parsedListCarName = new ArrayList<>(Arrays.asList(parsedArrCarName));
        checkCarName(parsedListCarName);
        return parsedListCarName;
    }

    private static void checkCarName(List<String> parsedListCarName) {
        for(String carName: parsedListCarName){
            if(carName.length()>5){
                throw new IllegalArgumentException();
            }
        }
    }

    public static int getNumber(){
        System.out.println(SystemMessage.INPUT_TURN_NUMBER);
        String stringTurnNumber = Console.readLine();
        checkCarTurn(stringTurnNumber);
        int turnNumber = Integer.parseInt(stringTurnNumber);
        return turnNumber;
    }

    private static void checkCarTurn(String stringTurnNumber) {
        for(int i=0; i<stringTurnNumber.length(); i++){
            if(!Character.isDigit(stringTurnNumber.charAt(i))){
                throw new IllegalArgumentException();
            }
        }
    }
}
