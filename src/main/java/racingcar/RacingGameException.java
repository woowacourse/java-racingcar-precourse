package racingcar;

public class RacingGameException {

    private static final String LONGNAME_MESSAGE = "[ERROR] 자동차의 이름은 5자 이하여야 한다.";
    private static final String DUPLICATION_NAME_MESSAGE = "[ERROR] 하나의 자동차는 하나의 레인에만 참가할 수 있다.";
    private static final String NO_NAME_MESSAGE = "[ERROR] 자동차의 이름은 공백일 수 없다.";
    private static final String NAME_INPUT_EMPTY_MESSAGE = "[ERROR] 하나 이상의 자동차가 참가해야 한다.";
    private static final String NO_NUMBER_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private static final String ZERO_NUMBER_MESSAGE = "[ERROR] 0보다 큰 숫자를 입력해야 한다";
    private static final String MINUS_NUMBER_MESSAGE = "[ERROR] 음수를 입력할 수 없다";

    public static String checkNameInputException(String carNameInput)
        throws NameInputEmptyException, LongNameException, DuplicationException, NoNameException {
        if ("".equals(carNameInput)) {
            throw new NameInputEmptyException(NAME_INPUT_EMPTY_MESSAGE);
        }
        if (CarNameDivider.divideName(carNameInput).equals("LongName")) {
            throw new LongNameException(LONGNAME_MESSAGE);
        }
        if (CarNameDivider.divideName(carNameInput).equals("DuplicationName")) {
            throw new DuplicationException(DUPLICATION_NAME_MESSAGE);
        }
        if (CarNameDivider.divideName(carNameInput).equals("NoName")) {
            throw new NoNameException(NO_NAME_MESSAGE);
        }

        return carNameInput;
    }

    public static int checkTimesInputException(String timesInput)
        throws NoNumberException, ZeroNumberException, MinusNumberException {
        try {
            int times = Integer.parseInt(timesInput);

            if (times == 0) {
                throw new ZeroNumberException(ZERO_NUMBER_MESSAGE);
            }
            if (times < 0) {
                throw new MinusNumberException(MINUS_NUMBER_MESSAGE);
            }
            return times;
        } catch (NumberFormatException e) {
            throw new NoNumberException(NO_NUMBER_MESSAGE);
        }
    }

    public static void printLongNameInputMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printDuplicationInputMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printNoNameInputMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printNameInputMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printNoNumberInputMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printZeroInputMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printMinusInputMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}

class NoNameException extends Exception {

    public NoNameException(String msg) {
        super(msg);
    }
}

class LongNameException extends Exception {

    public LongNameException(String msg) {
        super(msg);
    }
}

class DuplicationException extends Exception {

    public DuplicationException(String msg) {
        super(msg);
    }
}

class NameInputEmptyException extends Exception {

    public NameInputEmptyException(String msg) {
        super(msg);
    }
}

class NoNumberException extends Exception {

    public NoNumberException(String msg) {
        super(msg);
    }
}

class ZeroNumberException extends Exception {

    public ZeroNumberException(String msg) {
        super(msg);
    }
}

class MinusNumberException extends Exception {

    public MinusNumberException(String msg) {
        super(msg);
    }
}