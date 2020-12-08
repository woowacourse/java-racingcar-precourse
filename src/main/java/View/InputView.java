package View;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Exception.NoCarExistException;
import Exception.RoundNumTypeException;

public class InputView {

    private static final String ASKING_ROUND_NUM = "시도할 횟수는 몇회인가요?";
    private static final String ASKING_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DELIMITER = ",";
    private static final int VALID_MINIMUM_CAR_NAMES_LENGTH = 1;

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputCarNames() {
        System.out.println(this.ASKING_CAR_NAMES);
        String carNames = this.scanner.nextLine();

        try {
            isCarExists(carNames);
            return this.convertToList(carNames);
        } catch(NoCarExistException e) {
            System.out.println(e.getMessage());
            System.exit(1);
            return null;
        }
    }

    public int inputRoundNum() {
        System.out.println(this.ASKING_ROUND_NUM);
        String roundNum = this.scanner.nextLine();
        try {
            this.isInteger(roundNum);
       } catch (RoundNumTypeException e) {
            System.out.println(e.getMessage());
            System.exit(1);
            return -1;
       }

       return Integer.parseInt(roundNum);
    }

    private List<String> convertToList(String target) {
       String [] arr = target.split(this.DELIMITER);
       return Arrays.asList(arr);
    }

    private void isCarExists(String inputCarNames) throws NoCarExistException {
        if(inputCarNames.length() < this.VALID_MINIMUM_CAR_NAMES_LENGTH) {
            throw new NoCarExistException();

        }
    }

    private void isInteger(String target) throws RoundNumTypeException {
        try{
            Integer.parseInt(target);
        }
        catch (NumberFormatException e) {
            throw new RoundNumTypeException();
        }
    }
}
