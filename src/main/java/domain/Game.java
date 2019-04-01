package domain;

import java.util.Scanner;

public class Game {

    String carName;

    public void run() {
        InputCarName();
    }

    public void InputCarName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carName = sc.nextLine();
    }
}
