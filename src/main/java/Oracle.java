import domain.InputError;
import domain.InputErrorCode;
import domain.InputErrorMessage;
import java.util.Vector;

public class Oracle {

    static InputError checkLength(Vector<String> names, int MAX) {
        InputError error = new InputError();

        for (String name : names
        ) {
            if(name.length() > MAX) {
                error.set(InputErrorCode.LENGTH_ERROR, InputErrorMessage.LENGTH_ERROR_MESSAGE);
            }
        }

        return error;
    }

    static boolean checkRepeatedName(String specificName, Vector<String> names) {
        boolean repetition = false;
        int count;

        count = InputHandler.countName(specificName, names);
        if(count > 1) {
            repetition = true;
        }

        return repetition;
    }

    static InputError checkRepetition(Vector<String> names) {
        InputError error = new InputError();
        boolean repetition = false;

        for (String name : names
             ) {
            repetition = checkRepeatedName(name, names);
            if(repetition == true) {
                error.set(InputErrorCode.REPETITION_ERROR, InputErrorMessage.REPETITION_ERROR_MESSAGE);
                break;
            }
        }

        return error;
    }

    static InputError checkEmptyString(Vector<String> names) {
        InputError error = new InputError();

        if(names.size() == 0) {
            error.set(InputErrorCode.EMPTY_ERROR, InputErrorMessage.EMPTY_ERROR_MESSAGE);
        }

        return error;
    }

    /*static boolean checkFaultyInput(Vector<String> names, int max) {
        boolean faulty = false;

        faulty = checkLength(names, max);
        if(faulty) {
            System.out.println("다섯 글자 이하의 이름을 입력해야 합니다.");
        }

        faulty = checkRepetition(names);
        if(faulty) {
            System.out.println("차의 이름들은 모두 고유해야 합니다.(중복되면 안 됩니다)");
        }

        faulty = checkEmptyString(names);
        if(faulty) {
            System.out.println("공백이 아닌 문자를 입력해주세요.");
        }

        return faulty;
    }
    */
}
