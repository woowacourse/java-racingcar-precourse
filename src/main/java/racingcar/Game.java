package racingcar;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private ArrayList<String> carList;

    public Game(Scanner scanner) {
        this.carList = AskCarInfo.askCarInfo(scanner);
        for (int i = 0; i< carList.size(); i++) {
            System.out.println(("size" + carList.get(i).length()));
            System.out.println(carList.get(i));
        }
    }


}
