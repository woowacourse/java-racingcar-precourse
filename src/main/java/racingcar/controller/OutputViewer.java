package racingcar.controller;

import java.util.List;

public class OutputViewer {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final int START_INDEX = 0;
    private static final int ONE = 1;

    void printExceedMaxLenCarNameErrorMessage() {
        System.out.println(ERROR_MESSAGE_PREFIX + "최대 자동차 이름 길이를 넘겼습니다.");
    }

    void printErrorInputTypeMessage() {
        System.out.println(ERROR_MESSAGE_PREFIX + "시도 횟수는 숫자여야 한다.");
    }

    void printInputHowManyTryMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    void printWinnerResultMessage(List<String> winnerCarNameList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우숭자 : ");
        for (int index = START_INDEX; index < winnerCarNameList.size(); index++) {
            stringBuilder.append(winnerCarNameList.get(index));
            if (index < winnerCarNameList.size() - ONE) {
                stringBuilder.append(", ");
            }
        }
        System.out.println(stringBuilder.toString());
    }

    void printHeadMessageBeforePrintResult() {
        System.out.println("\n실행 결과");
    }

    void printEachTryResult(List<String> resultOfEachRacingTry) {
        for (String racingResult : resultOfEachRacingTry) {
            System.out.println(racingResult);
        }
        System.out.println();
    }
}
