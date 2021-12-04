package racingcar.gamesource;

import java.util.ArrayList;
import java.util.List;

import racingcar.constants.ConstMessage;
import racingcar.utils.NamesInputCheck;
import racingcar.utils.RoundNumberInputCheck;

public class RacingGame {
    private List<Car> racingCars = new ArrayList<>();
    private int roundNum;

    public void playStart(){
        gameInit();

        System.out.println(ConstMessage.PLAY_RESULT_MESSAGE);

        while((roundNum--) != 0){
            playNextRound();
            printAllPosition();
        }

        printWinners();
    }

    private void gameInit(){
        List<String> names = NamesInputCheck.getRightNamesInput();

        for(String carName: names){
            racingCars.add(new Car(carName));
        }

        roundNum = RoundNumberInputCheck.getRightRoundNumberInput();
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
            winnersName.append(ConstMessage.NAME_AND_NAME_DELIMITER);
        }

        String lastWinnerName = winners.get(winners.size()-1).getName();
        winnersName.append(lastWinnerName);

        System.out.println(ConstMessage.FINAL_WINNER_MESSAGE + winnersName);
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
