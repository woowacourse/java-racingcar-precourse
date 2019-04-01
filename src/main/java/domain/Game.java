package domain;

import java.util.Scanner;

public class Game {

    String carName;
    String[] carNames;

    public void run() {
        do {
            InputCarName();
            SplitWithComma();
        }
        while (!CheckCarNameLength());
    }

    public void InputCarName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carName = sc.nextLine();
    }

    public void SplitWithComma() {
        carNames = carName.split(",");
    }

    public boolean CheckCarNameLength() {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                System.out.println("자동차 이름을 5자리 이하로 입력해주세요.");
                return false;
            }
        }

        return true;
    }
}
