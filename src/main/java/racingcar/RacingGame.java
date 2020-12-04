package racingcar;

import view.OutputView;

public class RacingGame {
    private final Cars cars;
    private final Rounds rounds;

    public RacingGame(Cars cars, Rounds rounds){
        this.cars = cars;
        this.rounds = rounds;
    }

    public void play(){
        OutputView.printResultMessage();
        do{
            cars.tryMoveAll();
            cars.printCarsPosition();
            OutputView.printRoundSeparator();
            rounds.next();
        }while(!rounds.isEnd());

        OutputView.printWinner(cars.getWinnerNames());
    }
}
