package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        Scanner scanner = new Scanner(System.in);
        String carName;
        int num;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carName = scanner.next();

        System.out.println("시도할 회수는 몇회인가요?");
        try{
            num = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("타입 오류");
        }
    }
}
