package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class Game {
    private final static List<Car> cars=new ArrayList();

    public static void play(){
        setCars();
    }
    private static void setCars(){
        String input=Console.readLine();
        parseStringToList(input);
    }
    private static void parseStringToList(String input){
        String[] carNames=input.split(",");
        for(String carName : carNames){
            cars.add(new Car(carName));
        }
    }
}
