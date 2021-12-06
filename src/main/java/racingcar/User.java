package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User implements IUser{
    private final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private Validation validation = new Validation();

    @Override
    public String[] inputCarName() {
        informInputCar();
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
    public int inputRoundNumber() {
        informInputCount();
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

    private void informInputCar() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    private void informInputCount() {
        System.out.println(INPUT_ROUND_MESSAGE);
    }

    private String[] parseName(String input){
        return input.split(",");
    }

    private void printErrorMessage(String message){
        System.out.println(message);
    }
}
