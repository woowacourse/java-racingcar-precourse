package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행


    }

    public static void input(int numberOfAttempts) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carName = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(carName, ",");

        System.out.println("시도할 회수는 몇회인가요?");

        numberOfAttempts = Integer.parseInt(bufferedReader.readLine());
    }

    public static void makeRandomNumber(int numberOfAttempts) {
        for (int j = 0; j < numberOfAttempts; j++) {
            int dice = Randoms.pickNumberInRange(0, 9);
        }
    }

    public static void game() {
        int dice = Randoms.pickNumberInRange(0, 9);

        if (dice >= 4) {

        }
    }

    public static void goOrStop() {
        makeRandomNumber();
        if (dice >= 4) {
            System.out.print("-");
        }
    }

    public static void winner() {
        if ()
    }

    public static void output() {
        System.out.println("최종 우승자 : " + winner);
    }
}
