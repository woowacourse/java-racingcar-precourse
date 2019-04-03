package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Race {

    private Scanner sc = new Scanner(System.in);

    private ArrayList<Car> car;
    private int count;

    // 레이스 실행
    public void doRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] name = sc.nextLine().split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        count = sc.nextInt();
        sc.nextLine();

        printWinner();
    }

    // 이름 조건 확인
    protected boolean isNameValid(String name) {
        return name.length() <= 5;
    }

    // 실행결과 출력
    private void printResult() {
        System.out.println("실행 결과");
        for (int i = 0; i < car.size(); i++) {
            System.out.println(car.get(i).getName() + " : " + car.get(i).getPosition());
        }

        System.out.println();
    }

    // 우승자 출력
    private void printWinner() {
        System.out.println("");

    }
}
