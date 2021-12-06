package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class User {

    //자동차 이름 입력
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
}
