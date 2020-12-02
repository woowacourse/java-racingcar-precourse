package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 게임이 진행되는 클래스
 */
public class Game {

    private final Scanner scanner;
    private final InputGuide inputGuide;
    private OutputGuide outputGuide;

    Game(Scanner scanner){
        this.scanner = scanner;
        this.inputGuide = new InputGuide(scanner);
    }

    public void play(){
        Stream<Car> stream = parseToStream(inputGuide.inputCars());
        outputGuide = new OutputGuide(stream);
        int moves = inputGuide.countMove();
        for(int i=0; i<moves; i++){
            stream.forEach(Car::run);
            outputGuide.showMove(stream);
        }
        outputGuide.showResult();
    }

    public Stream<Car> parseToStream(Car[] cars){
        ArrayList<Car> list = new ArrayList<>(Arrays.asList(cars));
        return list.stream();
    }

}
