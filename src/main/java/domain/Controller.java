package domain;

import java.util.Scanner;

public class Controller {

    String[] racer;

    public void askCarsName() {
        String names;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분");
            Scanner scanner = new Scanner(System.in);
            names = scanner.nextLine();

        } while (!checkNamesCriterion(names));

    }

    public void askNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        laps = scanner.nextInt();
    }

    /* 이름의 정당성 확인 및 split 기능 구현 */
    public boolean checkNamesCriterion(String name) {
        racer = name.split(",");

        for (String each : racer) {

            if (each.length() > 5) {
                System.out.println("이름을 5자 이하로 적어주세요");
                return false;
            }

        }

        return true;
    }

    public void startGame() {

    }

    public void checkCarsPosition() {

    }

    public void checkWinner() {

    }

}
