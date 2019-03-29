package domain;

import domain.interfaces.UserInterface;

import java.util.List;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {

    private boolean shouldPrintResultTitle = true;

    @Override
    public String promptCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public int promptProgressCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    @Override
    public void notifyInvalidCarNamesInput() {
        System.out.println("잘못된 입력입니다.");
    }

    @Override
    public void printProgress(List<Car> cars) {
        if (shouldPrintResultTitle) {
            System.out.println("\n실행결과");
            shouldPrintResultTitle = false;
        }

        StringBuilder sb = new StringBuilder();
        for (Car c : cars) {
            sb.append(c.getName()).append(" : ");
            for (int i = 0; i < c.getPosition(); i++) {
                sb.append('-');
            }
            System.out.println(sb.toString());
            sb.setLength(0);
        }
        System.out.println();
    }

    @Override
    public void printWinners(List<Car> cars) {
        String joinedCarNames = Utility.joinCarNames(cars, ", ");
        System.out.println(joinedCarNames + "가 최종 우승했습니다.");
    }
}
