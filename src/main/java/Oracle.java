import domain.InputReport;
import domain.InputReportCode;
import domain.InputReportMessage;
import java.util.Vector;

public class Oracle {

    static InputReport checkLength(Vector<String> names, int MAX) {
        InputReport error = new InputReport();

        for (String name : names
        ) {
            if(name.length() > MAX) {
                error.set(InputReportCode.LENGTH_ERROR, InputReportMessage.LENGTH_ERROR_MESSAGE);
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

    static InputReport checkRepetition(Vector<String> names) {
        InputReport error = new InputReport();
        boolean repetition = false;

        for (String name : names
             ) {
            repetition = checkRepeatedName(name, names);
            if(repetition == true) {
                error.set(InputReportCode.REPETITION_ERROR, InputReportMessage.REPETITION_ERROR_MESSAGE);
                break;
            }
        }

        return error;
    }

    static InputReport checkEmptyString(Vector<String> names) {
        InputReport error = new InputReport();

        if(names.size() == 0) {
            error.set(InputReportCode.EMPTY_ERROR, InputReportMessage.EMPTY_ERROR_MESSAGE);
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
