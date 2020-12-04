package racingcar;

import view.OutputView;

public class RacingGame {
    private final Cars cars;
    private final int totalRounds;
    private int nowRound;

    public RacingGame(Cars cars, int totalRounds){
        this.cars = cars;
        this.totalRounds = totalRounds;
        nowRound = 0;
    }

    public void play(){
        OutputView.printResultMessage();
        do{
            cars.tryMoveAll();
            cars.printCarsPosition();
            OutputView.printRoundSeparator();
        }while(checkGameEnd());
        printWinner();
    }

    private boolean checkGameEnd(){
        return nowRound > totalRounds;
    }

    private void printWinner(){

    }
}
