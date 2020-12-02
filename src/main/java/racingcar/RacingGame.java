package racingcar;

import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int FINISH=0;
    private static final String RESULT="실행 결과";

    private InputView inputView;
    private Cars cars;
    private Integer tryCount;

    public RacingGame(Scanner scanner){
        inputView=new InputView(scanner);
    }

    public void run(){
        input();
        System.out.println();
        System.out.println(RESULT);
        while(tryCount!=FINISH){
            cars.go();
            cars.printAllCarPosition();
            tryCount--;
        }
        cars.printWinner();
    }

    private void input(){
        cars=new Cars(inputView.getCarsByNaming());
        tryCount=inputView.getTryCount();
    }
}
