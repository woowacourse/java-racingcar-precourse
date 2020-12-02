package racingcar;

import java.util.stream.Stream;

/**
 * 주어진 결과를 출력하는 클래
 */
public class OutputGuide {

    private static final String WINNER_IS = "최종 우승자: ";
    public static final String SHOW_STATUS_LOG = "실행 결과";
    private final Car[] cars;
    private final int moves;

    public OutputGuide(Car[] cars, int moves){
        this.cars = cars;
        this.moves = moves;
    }

    public void showResult(){
        raceStart();
    }

    private void raceStart(){
        System.out.println(SHOW_STATUS_LOG);
        for(int i=0; i<moves; i++){
            race(cars);
            System.out.println();
        }
    }

    private void race(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            cars[i].run();
        }
    }

    private void findWinner(){

    }

    private void findMaxMove(){

    }

}
