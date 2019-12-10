package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private ArrayList<Car> carList = new ArrayList<Car>();
    private int tryCount = 0;

    void playGame(){
        initializeGame();
        System.out.println();
        System.out.println("실행결과");
        for(int i=0; i<tryCount; i++){
            moveAndPrintEachCar();
            System.out.println();
        }
    }

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
        System.out.println("경주할 자동차 이름 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
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
        System.out.println("시도할 회수는 몇회인가요?");
        tryCount = scanner.nextInt();
    }

    void moveAndPrintEachCar() {
        for(Car car : carList){
            car.moveForward();
            car.printPosition();
        }
    }

    int findMaxPosition(){
        ArrayList<Integer> carPositionList = new ArrayList<Integer>();
        for(Car car : carList){
            carPositionList.add(car.getPosition());
        }
        return Collections.max(carPositionList);
    }

}