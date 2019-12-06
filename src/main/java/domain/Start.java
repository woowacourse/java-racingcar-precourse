package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    public void startGame(){
        String carName;
        int tryChance;
        carName = requestCarName();
        String[] carNameList = splitCarName(carName);
        ArrayList<Car> carList = makeCar(carNameList);
        tryChance = requestTry();
    }

    public String requestCarName(){
        String carName;
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
        carName = scan.nextLine();
        return carName;
    }

    public int requestTry(){
        int tryChance;
        Scanner scan = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요");
        tryChance = scan.nextInt();
        return tryChance;
    }

    public String[] splitCarName(String carName){
        String[] carNameList = carName.split(",");
        return carNameList;
    }

    public ArrayList<Car> makeCar(String[] carNameList){
        ArrayList<Car> carList = new ArrayList<Car>();
        for(int sizeOfCar = 0; sizeOfCar < carNameList.length; sizeOfCar++){
            Car createCar = new Car(carNameList[sizeOfCar]);
            carList.add(createCar);
        }
        return carList;
    }
}
