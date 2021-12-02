package racingcar.gamesource;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.InputCheck;

public class RacingGame {
    private List<Car> cars;

    private void gameInit(){
        String input = Console.readLine();
        List<String> names = InputCheck.parseNames(input);

        for(String carName: names){
            cars.add(new Car(carName));
        }

    }

    void palyStart(){
        gameInit();
        int roundNum =0;

        //추가 구현 예정
    }

}
