package racingcar;

import java.util.Scanner;

public class ExceptionHandle {
    public boolean checkStringSize(String tmpCarNameSave){
        for(String t:tmpCarNameSave.split(",")){
            if(t.length()>4){
                System.out.println("[ERROR] 자동차의 이름은 5자 이하여야 한다.");
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
