package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private Scanner scanner;

    private Input() {
        scanner = new Scanner(System.in);
    }

    private static class InputHolder {
        public static final Input INSTANCE = new Input();
    }

    public static Input getInstance() {
        return InputHolder.INSTANCE;
    }

    public ArrayList<Car> enrollCarName() {
        ArrayList<Car> carList = new ArrayList<>();
        String input;
        String[] inputCarName;

        while (true) {
            input = scanner.nextLine();
            inputCarName = input.split(",");

            if (!InputException.getInstance().enrollCarNullName(inputCarName) || !InputException.getInstance().enrollCarOneName(inputCarName)
                    || !InputException.getInstance().enrollCarOverLength(inputCarName) || !InputException.getInstance().enrollCarBlankName(inputCarName)
                    || !InputException.getInstance().enrollCarOverlapName(inputCarName) || !InputException.getInstance().enrollCarLastComma(input)) {
                continue;
            }

            for (String name : inputCarName) {
                carList.add(new Car(name));
            }
            return carList;
        }
    }

    public int tryNumber() {
        String inputNumber;
        int tryNumber;
        while (true) {
            inputNumber = scanner.nextLine();
            if (!InputException.getInstance().tryNumberBlank(inputNumber)) {
                continue;
            }
            try {
                tryNumber = Integer.parseInt(inputNumber);
                scanner.close();
                return tryNumber;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERROR_OTHER_TRY_NUMBER.getMessage());
            }
        }
    }

}
