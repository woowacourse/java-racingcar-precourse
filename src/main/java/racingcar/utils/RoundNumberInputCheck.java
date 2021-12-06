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
            checkInputToInteger(input);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage() + ConstMessage.CORRECT_ROUND_INPUT_REQUEST);
            isPossible = false;
        }

        return isPossible;
    }

    private static void checkInputToInteger(String input) throws IllegalArgumentException{

        try{
            int roundNumber = Integer.parseInt(input);
            checkIsPositiveNumber(roundNumber);
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException(ConstMessage.NOT_INTEGER_INPUT_ERROR);
        }catch (IllegalArgumentException exception){
            throw exception;
        }

    }

    private static void checkIsPositiveNumber(int roundNumber) throws IllegalArgumentException{

        if(roundNumber < 0){
            throw new IllegalArgumentException(ConstMessage.NEGATIVE_INPUT_ERROR);
        }

    }

}
