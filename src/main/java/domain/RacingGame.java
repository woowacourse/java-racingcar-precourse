/*
*
* 클래스 이름 : RacingGame.java
*
* 버전 정보 : 1.0.1
*
* 날짜 : 2019.03.30
*
* 작성자 : 483759
* */

package domain;

import java.util.Scanner;

public class RacingGame {
  /*
  * Car 객체에 접근하여 게임을 진행하는 클래스
  * */

  public static String[] InputCarName(){
    /*
    * 차를 입력받는 메소드 1차 구현
    * 아직 Car 객체를 생성하는 부분을 구현하지 않았기때문에 임시로 배열 반환
    * */
    Scanner sc = new Scanner(System.in);
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)으로 구분)");
    String Input_str = sc.nextLine();
    String[] carName = Input_str.split(",");

    return carName;
  }

  public static Car CreateCarObject(String carName){
    Car carObject = new Car(carName);
    return carObject;
  }

  public static Car[] CreateCarList(String[] carName){
    /*
    * 저장된 차 이름에 대한 String 배열을 인자로 받아와
    * Car 인스턴스 배열을 반환하는 메소드
    * */
    Car[] c = new Car[10];
    for(int i=0;i<carName.length;i++){
      c[i] = CreateCarObject(carName[i]);
    }
    return c;
  }

  public static int InputTryNumber(){
    Scanner sc = new Scanner(System.in);
    System.out.println("시도할 회수는 몇회인가요?");
    int tryNum = sc.nextInt();
    return tryNum;
  }

  public static void CarRacing(Car[] carList){
    for(int i=0;i<carList.length;i++){
      int random = carList[i].RandomMove();
      carList[i].CalculateLocation(random);
    }
  }

  public static void main(String args[]){
    String[] carName =  InputCarName();
    Car[] carList =CreateCarList(carName);
    int tryNum = InputTryNumber();
    CarRacing(carList);

    /*
    for (int i = 0; i < str.length; i++) {
      System.out.println(c[i].getCarName());
    }*/
  }
}
