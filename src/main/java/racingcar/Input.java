package racingcar;

import java.util.Scanner;

public class Input {
    private Scanner scanner;
    private String pattern = "^[0-9]+$";

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = scanner.nextLine();
        String[] names = makeValidNameList(inputNames);
        return names;
    }

    public int getMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputNum = scanner.nextLine();
        int moveCount = makeValidMoveCount(inputNum);
        return moveCount;
    }

    private String[] makeValidNameList(String inputNames) {
        String[] names = inputNames.split(",");
        if (names.length == 0) {
            throw new IllegalArgumentException("[ERROR] 하나 이상의 자동차 이름을 입력해야 합니다.");
        }
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
            if (!checkNameLen(names[i])) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 0글자 이상 5글자 이하여야 합니다.");
            }
        }
        return names;
    }

    private boolean checkNameLen(String input) {
        return (input.length() <= Constant.MAX_NAME_LEN) && (input.length() > Constant.MIN_NAME_LEN);
    }

    private int makeValidMoveCount(String inputNum) {
        for(int i=Constant.ZERO; i<inputNum.length(); i++){
            if (!String.valueOf(inputNum.charAt(i)).matches(pattern)) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수에는 숫자만 입력 가능합니다.");
            }
        }
        try {
            return Integer.parseInt(inputNum);
        }catch (NumberFormatException e){
            throw new NumberFormatException("[ERROR] 입력하신 수의 범위가 유효하지 않습니다.");
        }
    }
}
