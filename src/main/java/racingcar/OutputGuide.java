package racingcar;

import java.util.stream.Stream;

/**
 * 주어진 결과를 출력하는 클래
 */
public class OutputGuide {

    private static final String WINNER_IS = "최종 우승자: ";
    private final Stream<Car> stream;

    public OutputGuide(Stream<Car> stream){
        this.stream = stream;
    }

    public void showMove(Stream<Car> stream){
        stream.forEach(car -> System.out.println(car.getName() + " : " + car.getPosition()));
    }

    public void showResult(){

    }

}
