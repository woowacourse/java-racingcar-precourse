package racingcar.gamesource;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.InputCheck;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    private void gameInit(){
        String input = Console.readLine();
        List<String> names = InputCheck.parseNames(input);

        for(String carName: names){
            cars.add(new Car(carName));
        }

    }

    public void playStart(){
        gameInit();
        int roundNum =0;

        //추가 구현 예정
    }

    private void playNextRound(){

        for(Car car: cars){
            car.drive();
        }

    }

    private void printAllPosition(){

        for(Car car: cars){
            System.out.println(car.toString());
        }

        System.out.print('\n');
    }

}
