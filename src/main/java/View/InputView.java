package View;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final int VALID_MINIMUM_CAR_NAMES_LENGTH = 2;
    private final String ERROR_TAG = "[Error]";
    private final String INVAlID_INPUT_MESSAGE = "You should input at least one car name";
    private final String ASKING_ROUND_NUM = "시도할 횟수는 몇회인가요?";
    private final Scanner scanner;

   public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputCarNames() {
        String carNames = this.scanner.nextLine();

        if(!isValidInput(carNames)) {
            Exception e = new Exception(ERROR_TAG + INVAlID_INPUT_MESSAGE);
            System.out.println(e.toString());
        }

        return this.ConvertToList(carNames);
    }

    public int inputRoundNum() {
       System.out.println(this.ASKING_ROUND_NUM);
       int roundNum = this.scanner.nextInt();
       return roundNum;
    }
    private List<String> ConvertToList(String target) {
        return Arrays.asList(target.split(","));
    }

    private boolean isValidInput(String inputCarNames) {
        if(inputCarNames.length() < VALID_MINIMUM_CAR_NAMES_LENGTH) {
            return false;
        }
        return true;
    }



}
