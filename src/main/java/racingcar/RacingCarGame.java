package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Cars;
import racingcar.domain.RepetitionNumber;
import racingcar.view.Input;

public class RacingCarGame {
    private Cars cars;
    private RepetitionNumber repetitionNumber;
    private List<String> winners;

    public RacingCarGame(){
        winners = new ArrayList<String>();
    }

    public void run(){
        initialize();
        round();

    }

    private void round(){
     cars.play(repetitionNumber);
    }

    private void initialize(){
        cars = Input.inputCarNames();
        repetitionNumber =  Input.inputRepetitionNumber();
    }
}
