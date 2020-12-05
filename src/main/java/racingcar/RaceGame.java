package racingcar;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RaceGame {

    private Scanner scanner;
    private List<Car> carList;

    public RaceGame(Scanner scanner){
        this.scanner = scanner;
    }

    public void inputCarsName(){
        InputView.getCarList(scanner);
    }

    public void checkForwardMovement(){

    }
}
