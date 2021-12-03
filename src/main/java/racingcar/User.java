package racingcar;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class User implements IUser{
    @Override
    public String[] inputCarName() {
        while (true) {
            String[] result = parseName(Console.readLine());
            if (validateLength(result)) {
                return result;
            }
            informInputAgain();
        }
    }

    @Override
    public int inputRepeatNumber() {
        while (true) {
            String input = Console.readLine();
            if (validateNumber(input) && validateRange(input)) {
                return Integer.parseInt(input);
            }
            informInputAgain();
        }
    }

    @Override
    public void informInputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void informInputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private String[] parseName(String input){
        return input.split(",");
    }

    private boolean validateLength(String[] inputList) {
        long wrongNumberCount = Arrays.stream(inputList)
                .filter(s -> s.length() > 5).count();
        if (wrongNumberCount != 0) {
            return false;
        }
        return true;
    }

    private void informInputAgain() {
        System.out.println("[ERROR] 잘못된 값입니다. 올바른 값을 입력해주세요.");
    }

    private boolean validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean validateRange(String input) {
        if (Integer.parseInt(input) < 0) {
            return false;
        }
        return true;
    }

}
