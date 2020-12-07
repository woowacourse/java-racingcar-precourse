package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Race {
    private ArrayList<Car> cars = new ArrayList();
    private ArrayList<String> winners = new ArrayList();

    public static void runRace(){

    }


    public static String[] inputCarName(Scanner scanner){
        String[] players = scanner.nextLine().split(",");
        return players;
    }

    public static int inputTimes(Scanner scanner){
        return scanner.nextInt();
    }

    public int findMaxPosition(){
        int maxPosition = -1;
        int tempPosition;
        for (Car car : cars){
            tempPosition = car.getCarPosition()
            if (maxPosition <= tempPosition) { maxPosition = tempPosition; }
        }
        return maxPosition;
    }

    public static void printWinnerList(){

    }



}
