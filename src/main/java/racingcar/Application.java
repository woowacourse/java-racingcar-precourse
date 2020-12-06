package racingcar;

import domain.InputCarName;
import domain.Trial;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
//        System.out.println(Trial.inputCountValidate(scanner));
        String strList = InputCarName.inputCarName(scanner);
        System.out.println(strList);
    }
}