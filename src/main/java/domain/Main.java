/**
 * Main 클래스
 * <p>
 * 자동차 이름, 이동 횟수 입력 받을 예정
 * run() 함수도 호출할 예정
 * 이동 횟수만큼 반복 예정
 */
package domain;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String carNames;
        String[] splitedCarNames;
        int iterationNumber;
        int traceIterationNumber = 0;


        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        carNames = scanner.next();
        splitedCarNames = carNames.split(",");

        for (String isLessThanFive : splitedCarNames) {
            System.out.println("이름 : " + isLessThanFive + " 이름의 길이 : " + isLessThanFive.length());
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        iterationNumber = scanner.nextInt();

        for (int i = 0; i < iterationNumber; i++) {
            System.out.println((i+1) +"번");
        }


    }


}
