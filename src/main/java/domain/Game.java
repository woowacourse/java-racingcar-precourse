package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Car> carList = new ArrayList<>();
    private int tryCount = 0;

    void initializeGame(){
        setCarList();
        setTryCount();
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

    void setTryCount(){
        Scanner scanner = new Scanner(System.in);
        tryCount = scanner.nextInt();
    }

}