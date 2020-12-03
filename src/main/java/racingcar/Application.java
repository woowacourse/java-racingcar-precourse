package racingcar;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

//        System.out.println(InputCarName.inputCarName());
//        System.out.println(InputCarName.inputCount());
        String cars = InputCarName.inputCarName();
        String[] carsList = cars.split(",");
        System.out.println(InputCarNameCheck.checkAllCarNameLength(carsList));
    }

}
