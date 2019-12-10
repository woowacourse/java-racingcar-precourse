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
        printWinnerName();
    }

    public void initializeGame(){
        getCarList();
        getTryCount();
    }

   public void getCarList(){
        String[] carNameList;
        do {
            carNameList = getCarNameList();
        }while(!checkNameList(carNameList));
        makeCarList(carNameList);
    }

    public String[] getCarNameList(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameList = scanner.nextLine().split(",");
        return carNameList;
    }

    public boolean checkNameList(String[] carNameList){
        for(String name : carNameList){
            if(name.length() > 5) {
                System.out.println("차 이름은 5자 이하여야 합니다.");
                return false;
            }
        }
        return true;
    }

    public void makeCarList(String[] carNameList){
        for(String s : carNameList){
            carList.add(new Car(s));
        }
    }

    public void getTryCount(){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            tryCount = scanner.nextInt();
        }while(!checkTryCount(tryCount));
    }

    public boolean checkTryCount(int tryCount){
        Object tryCountObject = tryCount;
        if(tryCountObject instanceof Integer) {
            return true;
        }
        System.out.println("시도할 회수는 숫자이어야 합니다.");
        return false;
    }


   public void moveAndPrintEachCar() {
        for(Car car : carList){
            car.moveForward();
            car.printPosition();
        }
    }

    public void printWinnerName(){
        ArrayList<String> winnerNameList = getWinnerName();
        int winnerNameListLength = winnerNameList.size();
        for(int i=0; i<winnerNameListLength-1; i++){ System.out.print(winnerNameList.get(i) + ",");}
        System.out.println(winnerNameList.get(winnerNameListLength-1)+"가 최종우승 했습니다.");
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