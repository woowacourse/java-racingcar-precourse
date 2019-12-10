package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Car> carList = new ArrayList<>();

    void initializeGame(){
        getCarList();
    }
    void getCarList(){
        String carListAsString;
        carListAsString = inputCarList();
    }

    String inputCarList(){

        Scanner scanner = new Scanner(System.in);
        String carListAsString = scanner.nextLine();
        return carListAsString;
    }

}