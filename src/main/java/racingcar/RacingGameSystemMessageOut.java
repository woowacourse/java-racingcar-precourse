package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

public class RacingGameSystemMessageOut {
    public static final String NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TIMES_INPUT = "시도할 회수는 몇회인가요?";
    public static final String RESULT_MOVES = "실행 결과";
    public static final String RESULT_FINAL_WINNERS = "최종 우승자: ";

    public static void printNameInput() {
        System.out.println(NAME_INPUT);
    }

    public static void printTimesInput() {
        System.out.println(TIMES_INPUT);
    }

    public static void printResultMoves() {
        System.out.println(RESULT_MOVES);
    }

    public static void printEachMoves(HashMap<String, Integer> racingPlayBoard) {
        for(String carName : racingPlayBoard.keySet()) {
            System.out.print(carName + " : ");
            printEachMovesBars(racingPlayBoard.get(carName));
            System.out.println();
        }
        System.out.println();
    }

    public static void printEachMovesBars(int position) {
        for(int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

    public static void printFinalWinners(ArrayList<String> racingGameWinners) {
        System.out.print(RESULT_FINAL_WINNERS);
        for(String winner : racingGameWinners) {
            System.out.print(winner);
        }
    }
}
