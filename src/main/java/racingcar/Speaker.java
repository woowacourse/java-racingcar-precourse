package racingcar;

import java.util.Collections;

public class Speaker {

    public void sayCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void sayRepeatTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void sayErrorMessage(String message) {
        System.out.println(message);
        System.out.println("다시 입력해주세요.");
    }

    public void sayRacingStart() {
        System.out.println("실행 결과");
    }

    public void sayPresentCarLocation(String carName, int position) {
        System.out.println(carName + " : " + String.join("", Collections.nCopies(position, "-")));
    }

    public void newLine() {
        System.out.println();
    }

    public void sayWinners(StringBuilder winnerList) {
        System.out.println(winnerList);
    }
}
