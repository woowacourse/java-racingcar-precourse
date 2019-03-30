package domain;

import java.util.Scanner;

public class RacingCar {

    private void gameStart() {
        Scanner sc = new Scanner(System.in);
        RacingCarGame rcg = new RacingCarGame(totalCarsName(sc));
        int maxCount = totalTryCounter(sc);
        System.out.println("\n실행 결과");
        for (int i = 0; i < maxCount; i++) {
            rcg.startRacingGame();
        }
        rcg.setMaxPosition();
        rcg.printVictoryCar();
    }

    private String totalCarsName(Scanner sc) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return sc.nextLine();
    }

    private int totalTryCounter(Scanner sc) {
        System.out.println("시도할 회수는 몇회인가요?");
        int cnt = sc.nextInt();
        if (cnt < 0) {
            System.out.println("0보다 작은 수를 입력하셨습니다!");
            System.exit(0);
        }
        return cnt;
    }

    public static void main(String[] args) {
        RacingCar rc = new RacingCar();
        rc.gameStart();
    }
}
