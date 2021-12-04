package racingcar;

/**
 * @apiNote
 * carNameValidation 메서드는 carName 변수를 Validation 한다.
 * numOfTryValidation 메서드는 numOfTry 변수를 Validation 한다.
 *
 * @author 장준영
 */

public class Validation {
    static int NAME_LENGTH_LIMIT = 5;

    public String[] carNameValidation(String inputValue) throws IllegalArgumentException{
        String[] nameOfCarArray = inputValue.split(",");

        for(String name: nameOfCarArray){
            if(name.length() > NAME_LENGTH_LIMIT){
                throw new IllegalArgumentException();
            }
        }
        return nameOfCarArray;
    }

    public int numOfTryValidation(String inputValue) throws IllegalArgumentException{
        int result;
        try {
            result = Integer.parseInt(inputValue);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
