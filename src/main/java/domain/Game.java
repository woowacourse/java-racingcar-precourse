package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Car> carList = new ArrayList<>();

    void initializeGame(){
        setCarList();
    }
    void setCarList(){
        String[] carNameList;
        carNameList = getCarNameList();
        makeCarList(carNameList);
    }

    String[] getCarNameList(){
        Scanner scanner = new Scanner(System.in);
        String[] carNameList = scanner.nextLine().split(",");
        return carNameList;
    }

    void makeCarList(String[] carNameList){
        for(String s : carNameList){
            carList.add(new Car(s));
        }
    }

}