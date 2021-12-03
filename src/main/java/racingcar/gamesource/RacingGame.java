package racingcar.gamesource;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.InputCheck;

public class RacingGame {
    private List<Car> racingCars = new ArrayList<>();

    public void playStart(){
        gameInit();
        int roundNum =0;

        //추가 구현 예정
    }

    private void gameInit(){
        String input = Console.readLine();
        List<String> names = InputCheck.parseNames(input);

        for(String carName: names){
            racingCars.add(new Car(carName));
        }

    }

    private void playNextRound(){

        for(Car car: racingCars){
            car.drive();
        }

    }

    private void printAllPosition(){

        for(Car car: racingCars){
            System.out.println(car.toString());
        }

        System.out.print('\n');
    }

    private void printWinners(){
        List<Car> winners = getWinners();
        StringBuilder winnersName = new StringBuilder("");

        for(int i=0; i<winners.size()-1 ; ++i){
            winnersName.append(winners.get(i).getName());
            winnersName.append(", ");
        }

        String lastWinnerName = winners.get(winners.size()-1).getName();
        winnersName.append(lastWinnerName);

        System.out.println("최종 우승자 : " + winnersName);
    }

    private List<Car> getWinners(){
        List<Car> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for(Car car: racingCars){

            if(car.getPosition() == maxPosition){
                winners.add(car);
            }

        }

        return winners;
    }

    private int getMaxPosition(){
        int maxPosition = 0;

        for(Car car: racingCars){
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

}
