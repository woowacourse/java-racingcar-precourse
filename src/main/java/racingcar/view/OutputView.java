package racingcar.view;

import racingcar.Car;

import java.util.List;

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

    public static void printRoundResult(List<Car> carList){
        for(Car car : carList){
            System.out.print(car.getName());
            System.out.print(" : ");
            for(int i=0; i<car.getPosition(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinners(){

    }

}
