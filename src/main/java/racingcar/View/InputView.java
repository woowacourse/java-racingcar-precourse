package racingcar.View;

import racingcar.Domain.Cars;
import racingcar.Exceptions.TryCommandNumberException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static Cars readCarName(){

        return Cars.createCarByName(readLine());
    }

    public static int readTryCount(){
        return checkValidateNum(readLine());
    }
    public static int checkValidateNum(String input){
        return convertInt(input);
    }

    private static int convertInt(String input) {
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException exception) {
            throw new TryCommandNumberException();
        }
    }
}
