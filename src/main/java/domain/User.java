package domain;

import java.util.Scanner;

public class User {

    public String[] inputCarNames() {
        String carNames;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = scan.nextLine();
            String[] carArray = carNames.split(",");
            if (!verifyCarName(carArray)) {
                System.out.println("다시 입력해 주세요.");
            }
        }
    }

    private boolean verifyCarName(String[] carArray) {
        for (String oneName : carArray) {
            if (oneName.length() > 5 || oneName.length() == 0) {
                return false;
            }
        }
        return true;
    }

    public int getTurnNumber() {
        int turnNumber = 0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("시도할 횟수는 몇 회인가요?");
            turnNumber = scan.nextInt();
            if (turnNumber > 0) {
                break;
            }
            System.out.println("다시 입력해 주세요.");
        }
        return turnNumber;
    }

}
