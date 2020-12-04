package racingcar;

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
        do{
            moveCars();
            printCarsPosition();
        }while(checkGameEnd());
        printWinner();
    }

    private void moveCars(){

    }

    private void printCarsPosition(){

    }

    private boolean checkGameEnd(){
        return nowRound > totalRounds;
    }

    private void printWinner(){

    }
}
