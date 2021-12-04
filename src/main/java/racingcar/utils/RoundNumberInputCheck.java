package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.ConstMessage;

public class RoundNumberInputCheck {

    public static int getRightRoundNumberInput(){
        String input;

        do{
            System.out.println(ConstMessage.ROUND_NUMBER_INPUT_REQUEST);
            input = Console.readLine();
        }while(!checkIsPossibleNumber(input));

        return Integer.parseInt(input);
    }

    private static boolean checkIsPossibleNumber(String input){
        boolean isPossible = true;

        try{
            checkStringToPositiveNumber(input);
        }catch (IllegalArgumentException exception){
            System.out.println(ConstMessage.ROUND_INPUT_ERROR);
            isPossible = false;
        }

        return isPossible;
    }

    private static void checkStringToPositiveNumber(String input) throws IllegalArgumentException{
        int roundNumber;
        
        try{
            roundNumber = Integer.parseInt(input);
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException();
        }
        
        if(roundNumber < 0){
            throw new IllegalArgumentException();
        }
        
    }

}
