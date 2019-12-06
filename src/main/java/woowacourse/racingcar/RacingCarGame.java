package woowacourse.racingcar;

import java.util.Scanner;

public class RacingCarGame {
    private Scanner sc = new Scanner(System.in);

    public void runGame() {
        String [] carNames = this.getCarNames();
        int tryNumber = this.getTryNumber();
        this.startRacing(carNames, tryNumber);
    }

    private String [] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return sc.nextLine().split(",");
    }

    private int getTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }

    private void startRacing(String [] names, int tryNumber) {
        System.out.println("실행 결과");
    }
}
