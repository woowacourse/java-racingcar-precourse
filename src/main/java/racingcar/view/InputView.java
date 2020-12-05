package racingcar.view;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static List<Car> getCarList(Scanner scanner){
        String nameSentence = scanner.next();
        List<String> nameList = getValidNames(nameSentence);


        List<Car> carList = new ArrayList<>();

        return new ArrayList<>();
    }

    private static List<String> getValidNames(String nameSentence){

        return new ArrayList<>();
    }

    private static List<String> splitString(String nameSentence){

        return new ArrayList<>();
    }

    public static int getRepetitionCount(){

        return 0;
    }
}
