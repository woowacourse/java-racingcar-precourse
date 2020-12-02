package racingcar;

import com.sun.tools.javac.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * 주어진 결과를 출력하는 클래스
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
        System.out.println(findWinner());
    }

    private void raceStart(){
        System.out.println(SHOW_STATUS_LOG);
        for(int i=0; i<moves; i++){
            race(cars);
            System.out.println(findWinner());
        }
    }

    private void race(Car[] cars) {
        Arrays.stream(cars)
            .forEach(Car::run);
    }

    private String findWinner(){
        int max = findMaxMove();
        return "";
    }

    private int findMaxMove(){
        List<Integer> positions = null;
        Arrays.stream(cars)
            .forEach(car->positions.add(car.getPositionNumber()));
        return Collections.max(positions);
    }
}
