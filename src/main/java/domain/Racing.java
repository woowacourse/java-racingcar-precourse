package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racing {
    public void run() {
        for (String str : inputCarNames()) {
            System.out.println(str);
        }
    }

    public String[] inputCarNames() {
        Scanner scan = new Scanner(System.in);
        String[] carNameList;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNameList = scan.next().split(",");
        } while (checkFiveWords(carNameList));

        return carNameList;
    }

    public boolean checkFiveWords(String[] carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                System.out.println("이름이 5자가 넘었습니다. 다시 작성해주세요.");
                return true;
            }
        }
        return false;
    }
}
