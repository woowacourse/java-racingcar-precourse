import domain.InputReport;
import domain.InputReportCode;
import domain.InputReportMessage;

import java.util.Vector;

public class Oracle {

    static InputReport checkLength(Vector<String> names, int MAX) {
        InputReport report = new InputReport();

        for (String name : names
        ) {
            if (name.length() > MAX) {
                report.set(InputReportCode.LENGTH_ERROR, InputReportMessage.LENGTH_ERROR_MESSAGE);
            }
        }

        return report;
    }

    static boolean checkRepeatedName(String specificName, Vector<String> names) {
        boolean repetition = false;
        int count;

        count = InputHandler.countName(specificName, names);
        if (count > 1) {
            repetition = true;
        }

        return repetition;
    }

    static InputReport checkRepetition(Vector<String> names) {
        InputReport report = new InputReport();
        boolean repetition = false;

        for (String name : names
        ) {
            repetition = checkRepeatedName(name, names);
            if (repetition == true) {
                report.set(InputReportCode.REPETITION_ERROR, InputReportMessage.REPETITION_ERROR_MESSAGE);
                break;
            }
        }

        return report;
    }

    static InputReport checkEmptyString(Vector<String> names) {
        InputReport report = new InputReport();

        if (names.size() == 0) {
            report.set(InputReportCode.EMPTY_ERROR, InputReportMessage.EMPTY_ERROR_MESSAGE);
        }

        return report;
    }

    static boolean isThereError(Vector<InputReport> reports) {
        for (InputReport report : reports
        ) {
            if (report.showCode() != 0) {
                return true;
            }
        }

        return false;
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
