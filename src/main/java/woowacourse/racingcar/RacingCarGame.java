package woowacourse.racingcar;

import java.util.Scanner;

public class RacingCarGame {
    private Scanner sc = new Scanner(System.in);

    public void runGame() {
        String carNames = getCarNames();
        int tryNumber = getTryNumber();

    }

    private String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String getNames = sc.nextLine();
        return getNames;
    }

    private int getTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        int getNumber = sc.nextInt();
        return getNumber;
    }
}
