package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.Application.carList;

public class Race {

    public static void doOneIterationRace() {
        int rand;

        for (int i = 0; i < carList.size(); i++) {
            rand = Randoms.pickNumberInRange(0, 9);
            if (rand >= 4) {
                carList.get(i).goForward();
            }
        }
        printOneIterationResult();
        System.out.printf("\n");
    }

    public static void determineWinner() {
        // 1 pass : position 중에 최댓값 구하기
        int maxVal = -1;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() >= maxVal) {
                maxVal = carList.get(i).getPosition();
            }
        }

        // 2 pass : position 최댓값을 갖는 Car 객체를 출력
        System.out.printf("최종 우승자 : ");
        printWinners(maxVal);
    }

    public static void printOneIterationResult() {
        for (int i = 0; i < carList.size(); i++) {
            printCarPosition(carList.get(i));
        }
    }

    public static void printCarPosition(Car carObj) {
        System.out.printf("%s : ", carObj.getName());
        for (int i = 0; i < carObj.getPosition(); i++) {
            System.out.printf("-");
        }
        System.out.printf("\n");
    }

    public static void printWinners(int maxVal) {
        // 1st 우승자
        int idx = 0;
        for (idx = 0; idx < carList.size(); idx++) {
            if (carList.get(idx).getPosition() == maxVal) {
                System.out.printf("%s", carList.get(idx).getName());
                break;
            }
        }
        // 인덱스 이어서 2nd 우승자부터 다시 출력
        for (int i = ++idx; i < carList.size(); i++) {
            if (carList.get(i).getPosition() == maxVal) {
                System.out.printf(", %s", carList.get(i).getName());
            }
        }
        System.out.printf("\n");
    }
}
