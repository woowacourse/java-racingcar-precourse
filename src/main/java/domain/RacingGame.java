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
    String[] Car_arr = Input_str.split(",");

    return Car_arr;
  }

  public static void main(String args[]){

  }
}
