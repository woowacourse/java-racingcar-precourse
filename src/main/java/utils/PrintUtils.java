package utils;

import java.util.List;
import racingcar.Car;

/**
 * 프로그램의 출력 부분을 담당하는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/05
 */
public class PrintUtils {

    public void printInputNamesGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputNumberGuide() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printNameErrorMessage() {
        System.out.println("[ERROR] 이름은 5자리 이하 문자를 입력해주세요.");
    }

    public void printNumberErrorMessage() {
        System.out.println("[ERROR] 양의 정수를 입력해주세요.");
    }

    /* 차량들의 전진 상황을 출력하는 메소드 */
    public static void printCarsPosition(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            System.out.printf(carList.get(i).getName() + " : ");
            carList.get(i).printPosition();
            System.out.println("");
        }
        System.out.println("");
    }

    public static void printWinners(List<String> winnerList) {
        System.out.printf("최종 우승자: " + String.join(", ", winnerList));
    }

    public static void printGameResultMessage() {
        System.out.println("\n실행 결과");
    }
}
