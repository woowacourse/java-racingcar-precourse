package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

import static racingcar.Constant.*;

public class RaceGame {

    private Scanner scanner;
    private List<Car> carList;

    public RaceGame(Scanner scanner){
        this.scanner = scanner;
    }

    public void inputCarsName(){
        OutputView.printNormal(OUTPUT_VIEW_NAME);
        carList = InputView.getCarList(scanner);
    }

    public void checkForwardMovement(){

    }
}
