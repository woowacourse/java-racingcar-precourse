import domain.CarCreator;
import domain.CarMover;
import domain.InfoPrinter;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        CarCreator.createCar(sc.nextLine());
        System.out.println("시도할 횟수는 몇회인가요?");
        int moveCnt = sc.nextInt();
        System.out.println("\n실행결과");
        CarMover.repeat(moveCnt);
        InfoPrinter.printWinner();
    }
}
