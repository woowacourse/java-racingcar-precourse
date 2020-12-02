package racingcar;

import java.util.Scanner;

public class RacingGame {

    private static final int FINISH=0;
    private static final String RESULT="실행 결과";

    private InputView inputView;
    private Cars cars;
    private Integer tryCount;

    public RacingGame(Scanner scanner){
        inputView=new InputView(scanner);
        cars=new Cars();
    }

    public void run(){
        input();
        while(tryCount!=FINISH){
            cars.go();
            cars.printAllCarPosition();
            tryCount--;
        }
        cars.printWinner();
    }

    private void input(){
        inputView.getCarNames().forEach(carName->{
            cars.add(new Car(carName));
        });
        tryCount=inputView.getTryCount();
        System.out.println();
        System.out.println(RESULT);
    }
}
