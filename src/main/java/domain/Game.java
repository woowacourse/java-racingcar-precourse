package domain;

import java.util.Scanner;

public class Game {

    String carsName;

    public void run() {
        InputCarsName();
        //System.out.println(carsName);

    }

    public void InputCarsName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carsName = scan.nextLine();
    }
}
