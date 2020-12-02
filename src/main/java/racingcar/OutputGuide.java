package racingcar;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 주어진 결과를 출력하는 클래스
 */
public class OutputGuide {

    private static final String WINNER_IS = "최종 우승자: ";
    private static final String SHOW_STATUS_LOG = "실행 결과";
    private static final String MORE_WINNERS = ", ";
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
        }
    }

    private void race(Car[] cars) {
        Arrays.stream(cars)
            .forEach(Car::run);
        System.out.println();
    }

    private String findWinner(){
        int max = findMaxMove();
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(cars).forEach(car->{
            if(max == car.getPositionNumber()){
                stringBuilder.append(car.getName()+ MORE_WINNERS);
            }
        });
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(MORE_WINNERS));
        return WINNER_IS + stringBuilder.toString();
    }

    private int findMaxMove(){
        ArrayList<Integer> positions = new ArrayList<>();
        Arrays.stream(cars)
            .forEach(car->positions.add(car.getPositionNumber()));
        return Collections.max(positions);
    }
}
