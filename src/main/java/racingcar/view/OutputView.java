package racingcar.view;

import static racingcar.Constant.*;

public class OutputView {

    public OutputView() {
    }

    public static void printNormal(String normalMessage){
        System.out.println(normalMessage);
    }

    public static void printErrorMessage(String errorMessage){
        System.out.print(ERROR_HEADER);
        System.out.println(errorMessage);
    }

    public static void printRaceResults(){

    }

    public static void printWinners(){

    }

}
