package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User implements IUser{
    private Validation validation = new Validation();

    @Override
    public String[] inputCarName() {
        while (true) {
            String result = Console.readLine();
            try {
                validation.validateName(result);
                validation.validateLength(result);
                return parseName(result);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    @Override
    public int inputRepeatNumber() {
        while (true) {
            String input = Console.readLine();
            try {
                validation.validateNumber(input);
                validation.validateRange(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
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

    private void printErrorMessage(String message){
        System.out.println(message);
    }
}
