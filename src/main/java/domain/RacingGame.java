package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RacingGame {

  public void run() {
    ArrayList<Car> carArrayList = initCar();
    //initialize car names to each car object
  }

  public ArrayList<Car> initCar() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    Scanner scan = new Scanner(System.in);
    String carNames = scan.next();
    ArrayList<String> carNameList = new ArrayList<String>(Arrays.asList(carNames.split(",")));
    ArrayList<Car> carArrayList = new ArrayList<Car>();
    for(String car : carNameList){
      Car realCar = new Car(car);
      carArrayList.add(realCar);
    }
    return carArrayList;
  }
}
