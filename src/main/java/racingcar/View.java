package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class View {

    public void printCarsManual() {
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCountManual() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultManual() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public String input() {

        return Console.readLine();
    }

    void printError(String s) {
        System.out.println("[ERROR] " + s);
    }

    public void printScore(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.currentPosition());
        }
        System.out.println();
    }

    public void printWinner(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
