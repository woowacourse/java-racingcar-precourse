package view;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    public static void showNamesInputForm() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void showRoundsInputForm() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void showWinners(List<String> winners) {
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }
}
