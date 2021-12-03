package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        String carName;                         // 입력받을 차 이름
        String numOfTry;                        // 입력받을 경기 시도 횟수

        System.out.print("경주할 자동차 이름을 입력하세요.");
        System.out.println("(이름은 쉼표(,) 기준으로 구분)");
        carName = Console.readLine();
        System.out.println("시도할 횟수는 몇회인가요?");
        numOfTry = Console.readLine();
    }
}
