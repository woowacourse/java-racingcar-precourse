package domain;

import java.util.Scanner;

public class RacingCar {
    private String totalCarsName(Scanner sc){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return sc.nextLine();
    }
    private void gameStart(){
        Scanner sc = new Scanner(System.in);
        RacingCarGame rcg = new RacingCarGame(totalCarsName(sc));
    }
    public static void main(String[] args){
        RacingCar rc = new RacingCar();
        rc.gameStart();
    }
}
