import domain.Car;
import domain.InputReport;
import domain.InputReportCode;
import domain.InputReportMessage;

import java.util.Vector;

public class Oracle {
    static final String STRING_BETWEEN_CAR_NAME_AND_DASH = " : ";

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



    static boolean checkFaultyInput(Vector<String> names, int max) {
        Vector<InputReport> reports = InputReportHandler.gatherReports(names, max);
        InputReport error = InputReportHandler.findErrorReport(reports);

        if(error == null) {
            return false;
        }

        System.out.println(error);
        return true;
    }

    static boolean tellGoOrStop(int top, int bottom, int boundary) {
        int randomNumber = (int)(Math.random() * (top - bottom ));
        if (randomNumber >= boundary) {
            return true;
        }
        return false;
    }

    static void showRoundResult(Vector<Car> cars, char character) {
        for (Car car : cars
             ) {
            System.out.print(car);
            System.out.print(STRING_BETWEEN_CAR_NAME_AND_DASH);
            drawCharacters(car.positionIs(), character);
        }
    }

    static void drawCharacters(int count, char character) {
        for(int i = 0; i < count; i++) {
            System.out.print(character);
        }
        System.out.println();
    }

}
