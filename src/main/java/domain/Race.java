package domain;

import java.util.Scanner;

public class Race {

    private Scanner sc = new Scanner(System.in);
    private String[] name;
    private int count;

    // 레이스 실행
    public void doRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        name = sc.nextLine().split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        count = sc.nextInt();
        sc.nextLine();

        printWinner();
    }

    // 이름 조건 확인
    protected boolean isNameValid(String name) {
        return name.length() <= 5;
    }

    // 우승자 리턴
    private void printWinner() {

    }
}
