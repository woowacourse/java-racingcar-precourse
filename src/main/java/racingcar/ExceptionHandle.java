package racingcar;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class ExceptionHandle {
    private static final String ERROR_COMMA="콤마(,)의 갯수가 차 이름 수와 맞지 않습니다";
    private static final String ERROR_STRING_SIZE="[ERROR] 자동차의 이름은 5자 이하여야 한다.";
    private static final String ERROR_STRING_BLANK="[ERROR] 자동차의 이름은 1자 이상이여야 한다.";
    private static final String ERROR_STRING_REPEAT="[ERROR] 자동차의 이름은 중복되지 않아야 한다.";
    private static final String ERROR_INPUT_NUMBER_IS_NOT_LITERAL="[ERROR] 시도 횟수는 숫자여야 한다.";
    private static final String ERROR_INPUT_NUMBER_IS_POSITIVE="[ERROR] 시도 횟수는 양수여야 한다.";
    public boolean checkInputString(String tmpCarNameSaveParameter){
        if(!checkInputStringInComma(tmpCarNameSaveParameter)||!checkInputStringIsBlank(tmpCarNameSaveParameter)||!checkInputStringIsRepeat(tmpCarNameSaveParameter)||!checkInputStringSize(tmpCarNameSaveParameter)){
            return false;
        }
        return true;
    }
    public boolean checkInputStringInComma(String tmpCarNameSaveParameter){
        int nameNumber=0;
        for(String t:tmpCarNameSaveParameter.split(",")){
            nameNumber+=1;
        }
        if(countCommaNumber(tmpCarNameSaveParameter)!=nameNumber-1){
            System.out.println(ERROR_COMMA);
            return false;
        }
        return true;
    }
    public int countCommaNumber(String tmpCarNameSaveParameter){
        int commaNumber=0;
        for(int i=0;i<tmpCarNameSaveParameter.length();i++){
            if(tmpCarNameSaveParameter.charAt(i)==','){
                commaNumber+=1;
            }
        }
        return commaNumber;
    }
    public boolean checkInputStringSize(String tmpCarNameSaveParameter){
        for(String t:tmpCarNameSaveParameter.split(",")){
            if(t.length()>4){
                System.out.println(ERROR_STRING_SIZE);
                return false;
            }
        }
        return true;
    }
    public boolean checkInputStringIsBlank(String tmpCarNameSaveParameter){
        for(String t:tmpCarNameSaveParameter.split(",")){
            if(t.length()==0){
                System.out.println(ERROR_STRING_BLANK);
                return false;
            }
        }
        return true;
    }
    public boolean checkInputStringIsRepeat(String tmpCarNameSaveParameter){
        Map<String,Integer> tmpCheckMap =new HashMap<>();
        for(String t:tmpCarNameSaveParameter.split(",")){
            if(tmpCheckMap.containsKey(t)){
                System.out.println(ERROR_STRING_REPEAT);
                return false;
            }
            tmpCheckMap.put(t,0);
        }
        return true;
    }
    public boolean checkInputAttemptNumber(String tmpInputAttemptNumberParameter){
        if(!checkInputAttemptNumberIsNumber(tmpInputAttemptNumberParameter)||!checkInputAttemptNumberIsPositive(tmpInputAttemptNumberParameter)){
            return false;
        }
        return true;
    }
    public boolean checkInputAttemptNumberIsNumber (String tmpInputAttemptNumberParameter){
        try{
            Integer.parseInt(tmpInputAttemptNumberParameter);
            return true;
        }catch (NumberFormatException e){
            System.out.println(ERROR_INPUT_NUMBER_IS_NOT_LITERAL);
            return false;
        }
    }
    public boolean checkInputAttemptNumberIsPositive(String tmpInputAttemptNumberParameter){
        if(Integer.parseInt(tmpInputAttemptNumberParameter)<=0){
            System.out.println(ERROR_INPUT_NUMBER_IS_POSITIVE);
            return false;
        }
        return true;
    }
}
