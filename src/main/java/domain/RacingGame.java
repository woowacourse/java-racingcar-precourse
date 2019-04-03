package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RacingGame {

  ArrayList<Car> carArrayList;

  public void run() {
    carArrayList = initCar();
    //initialize car names to each car object
    System.out.println("시도할 횟수는 몇회인가요?");
    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    System.out.println("실행 결과");
    for (int i = 0; i < num; i++) {
      move();
      System.out.println();
    }
    getWinner();
  }

  public ArrayList<Car> initCar() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    Scanner scan = new Scanner(System.in);
    String carNames = scan.next();
    ArrayList<String> carNameList = new ArrayList<String>(Arrays.asList(carNames.split(",")));
    ArrayList<Car> carArrayList = new ArrayList<Car>();
    for (String car : carNameList) {
      Car realCar = new Car(car);
      carArrayList.add(realCar);
    }
    return carArrayList;
  }

  public void move() {
    for (Car thisCar : carArrayList) {
      thisCar.movePos();
      thisCar.showPos();
    }
  }

  public ArrayList<String> getWinner() {
    int max = 0;
    for (Car arrCar : carArrayList) {
      if (arrCar.getPosition() > max) {
        max = arrCar.getPosition();
      }
    }
    ArrayList<String> winner = new ArrayList<String>();
    for (Car arrCar : carArrayList) {
      if (arrCar.getPosition() == max) {
        winner.add(arrCar.getName());
      }
    }
    return winner;
  }


}
