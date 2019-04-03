package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Playgame {

    public static void main(String[] args) {

        private static int initSetup() {

            Scanner scan = new Scanner(System.in);

            String input = null;
            int Round = 0;

            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
            input = scan.nextLine();

            System.out.println("시도할 회수는 몇회인가요?");
            Round = scan.nextInt();
            System.out.println();

            return Round;

        }
    }
}
