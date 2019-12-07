package domain;

import java.util.Scanner;

public class GameManager {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Util util = new Util();

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String tempIn = sc.nextLine();
            util.splitCarName(tempIn);
        } while (!util.isNameLengthValid());
        System.out.println("시도할 회수는 몇회인가요?");
        int repeat = sc.nextInt();

        System.out.println("실행결과");
        util.repeatGameAndPrint(repeat);
    }
}
