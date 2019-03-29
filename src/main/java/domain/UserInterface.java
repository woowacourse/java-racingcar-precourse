package domain;

import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return sc.nextLine().split(",");
    }

    public int inputCnt(){
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }
}
