package racingcar.gamesource;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.InputCheck;

public class RacingGame {
    private List<Car> racingCars = new ArrayList<>();

    public void playStart(){
        gameInit();

        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int roundNum = Integer.parseInt(input);

        System.out.println("실행 결과\n");

        while((roundNum--) != 0){
            playNextRound();
            printAllPosition();
        }

        printWinners();
    }

    private void gameInit(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

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
