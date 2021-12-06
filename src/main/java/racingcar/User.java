package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class User {

    // 자동차 이름 입력
    public String[] InputCarName(){
        String carsString = Console.readLine();
        String[] cars = carsString.split(",");
        try {
            IsValidName(cars);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return InputCarName();
        }
        return cars;
    }

    private void IsValidName(String[] cars){
        for(String car : cars){
            if(car.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능하다.");
            }
        }
    }

    // 시도할 횟수 입력
    public Integer InputPlayNum(){
        String playNumString = Console.readLine();
        try{
            IsValidNum(playNumString);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return InputPlayNum();
        }
        return Integer.parseInt(playNumString);
    }

    private void IsValidNum(String num){
        for(int i=0; i<num.length(); i++){
            if(!Character.isDigit(num.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
            }
        }
    }
}
