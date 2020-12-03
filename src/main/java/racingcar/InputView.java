package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner scanner;
    private String userNames;
    private String userTrialCount;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserTrialCount(){
        return this.userTrialCount;
    }

    public String getUserNames(){
        return this.userNames;
    }


    public void parseUserNames() {
        String userNamesInput = null;
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            userNamesInput = scanner.nextLine();
            Validation.isValidUserNames(userNamesInput);
        } catch (Exception e) {
            System.err.println("[ERROR] 두명 이상 게임 진행이 가능합니다.");
            parseUserNames();
        }
    }

    public void parseUserTrialCount() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            this.userTrialCount = scanner.nextLine();
            Validation.isValidUserTrialCount(userTrialCount);

        } catch (Exception e) {
            System.err.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
            parseUserTrialCount();
        }
    }
}
