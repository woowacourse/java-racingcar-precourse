package domain;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 우아한 테크코스 2주차 MISSION "자동차경주게임"
 * 프리코스 참가자 : 최유성
 * Date : 2019/03/31
 */
public class RacingGame {
    public static void main(String[] args) {
        run();
    }

    static void infoName() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분합니다.");
    }

    static void infoStage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    static int setStage() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    static void startGame(InputCar input, ForwardCar forward, int stage) {
        for (int i = 0; i < stage; i++) {
            for (int j = 0; j < input.carNameList.length; j++) {
                forward.decideForward(input.carArr[j]);
                input.carArr[j].showStatus();
            }
            System.out.println("");
        }
    }

    static void EndGame(InputCar input) {
        int numCars = input.carArr.length;
        int[] endLine = new int[numCars];

        for (int i = 0; i < numCars; i++) {
            endLine[i] = input.carArr[i].getPosition();
        }
        Arrays.sort(endLine);

        for (int i = 0; i < numCars; i++) {
            if (input.carArr[i].getPosition() == endLine[endLine.length - 1]) {
                System.out.println(input.carArr[i].getName() + "이 최종 우승했습니다. Winner Winner Chicken Dinner");
            }
        }
    }

    static void run() {  //클래스를 선언하고 클래스의 메소드를 이용
        InputCar input = new InputCar();
        ForwardCar forward = new ForwardCar();

        int stage = 0;

        infoName();
        input.scanCar();
        input.setCar();
        infoStage();
        stage = setStage();
        startGame(input, forward, stage);
        EndGame(input);
    }
}
