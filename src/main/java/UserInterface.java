import domain.Results;

import java.util.Scanner;

public interface UserInterface {

    Scanner scanner = new Scanner(System.in);

    static String getCarNamesWithComma() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine();
    }

    static int getRemainingPlayCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
    }

    static void printResults(Results results) {
        System.out.println("실행 결과");
        System.out.println(results.getResults());
        printWinner(results);
    }

    static void printWinner(Results results) {
        System.out.println(String.join(", ", results.getWinners()) + "가 최종 우승했습니다.");
    }

}
