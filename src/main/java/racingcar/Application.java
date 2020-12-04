package racingcar;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] result = scanner.nextLine().split(",");
        System.out.println(InputCarNameCheck.checkInputCarName(result));
    }

}
