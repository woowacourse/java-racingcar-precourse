package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private ArrayList<Car> carList = new ArrayList<Car>();
    private int tryCount = 0;

    public void playGame(){
        initializeGame();
        System.out.println();
        System.out.println("실행결과");
        for(int i=0; i<tryCount; i++){
            moveAndPrintEachCar();
            System.out.println();
        }
    }

    public void initializeGame(){
        setCarList();
        setTryCount();
    }

   public void setCarList(){
        String[] carNameList;
        carNameList = getCarNameList();
        makeCarList(carNameList);
    }

    public String[] getCarNameList(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameList = scanner.nextLine().split(",");
        return carNameList;
    }

    public void makeCarList(String[] carNameList){
        for(String s : carNameList){
            carList.add(new Car(s));
        }
    }

    public void setTryCount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        tryCount = scanner.nextInt();
    }

    public void moveAndPrintEachCar() {
        for(Car car : carList){
            car.moveForward();
            car.printPosition();
        }
    }

    public ArrayList<String> getWinnerName(){
        ArrayList<String> winnerNameList = new ArrayList<String>();
        int maxPositon = findMaxPosition();
        for(Car car : carList){
            if(car.getPosition() == maxPositon) winnerNameList.add(car.getName());
        }
        return winnerNameList;
    }

    public int findMaxPosition(){
        ArrayList<Integer> carPositionList = new ArrayList<Integer>();
        for(Car car : carList){
            carPositionList.add(car.getPosition());
        }
        return Collections.max(carPositionList);
    }

}