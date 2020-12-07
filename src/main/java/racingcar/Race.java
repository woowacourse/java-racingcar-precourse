package racingcar;

import java.util.Scanner;

public class Race {

    public static String[] inputCarName(Scanner scanner){
        String[] players = scanner.nextLine().split(",");
        return players;
    }

    public static int inputTimes(Scanner scanner){
        return scanner.nextInt();
    }
}
