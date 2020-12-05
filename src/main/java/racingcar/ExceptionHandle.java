package racingcar;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class ExceptionHandle {
    public boolean checkInputString(String tmpCarNameSaveParameter){
        if(!checkInputStringIsBlank(tmpCarNameSaveParameter)||!checkInputStringIsRepeat(tmpCarNameSaveParameter)||checkInputStringSize(tmpCarNameSaveParameter)){
            return false;
        }
        return true;
    }
    public boolean checkInputStringSize(String tmpCarNameSaveParameter){
        for(String t:tmpCarNameSaveParameter.split(",")){
            if(t.length()>4){
                System.out.println("[ERROR] 자동차의 이름은 5자 이하여야 한다.");
                return false;
            }
        }
        return true;
    }
    public boolean checkInputStringIsBlank(String tmpCarNameSaveParameter){
        for(String t:tmpCarNameSaveParameter.split(",")){
            if(t.length()==0){
                System.out.println("[ERROR] 자동차의 이름은 1자 이상이여야 한다.");
                return false;
            }
        }
        return true;
    }
    public boolean checkInputStringIsRepeat(String tmpCarNameSaveParameter){
        Map<String,Integer> tmpCheckMap =new HashMap<>();
        for(String t:tmpCarNameSaveParameter.split(",")){
            if(tmpCheckMap.containsKey(t)){
                System.out.println("[ERROR] 자동차의 이름은 중복되지 않아야 한다.");
                return false;
            }
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
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            return false;
        }
    }
    public boolean checkInputAttemptNumberIsPositive(String tmpInputAttemptNumberParameter){
        if(Integer.parseInt(tmpInputAttemptNumberParameter)<=0){
            System.out.println("[ERROR] 시도 횟수는 양수여야 한다.");
            return false;
        }
        return true;
    }
}
