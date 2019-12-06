package domain;
import java.util.*;

public class Game {
    public static void gameStart(String carName, int count) {
        ArrayList<Car> carList = inputSlice(carName);

        for(int i = 0; i < count; i++) {
            racingSimulation(carList, count);
        }

        winnerCheck(carList);
    }

    public static ArrayList<Car> inputSlice(String carName) {
        ArrayList<Car> carList = new ArrayList<Car>();
        String[] carNames = carName.split(",");

        for(int i = 0; i < carNames.length; i++) {
            Car temp = new Car(carNames[i]);
            carList.add(temp);
        }
        return carList;
    }

    public static void racingSimulation(ArrayList<Car> carList, int count) {
        for(int j = 0; j < carList.size(); j++) {
            Car.addPosition(carList.get(j), RandomNumber.checkNumber());
        }

        System.out.println();
        
        for(int j = 0; j < carList.size(); j++) {
            Car.positionState(carList.get(j));
        }

        System.out.println();
    }

    public static void winnerCheck(ArrayList<Car> carList) {
        ArrayList<String> winner = new ArrayList<String>();
        int winnerPosition = 0;

        for(int i = 0; i < carList.size(); i++) {
            if(Car.carPosition(carList.get(i)) > winnerPosition) {
                winner = new ArrayList<String>();
                winner.add(Car.carName(carList.get(i)));
                winnerPosition = Car.carPosition(carList.get(i));
            }
            else if(Car.carPosition(carList.get(i)) == winnerPosition) {
                winner.add(Car.carName(carList.get(i)));
            }
        }
        winnerNotice(winner);
    }

    public static void winnerNotice(ArrayList<String> winner) {
        if(winner.size() == 1) {
            System.out.printf("%s가 우승했습니다.", winner.get(winner.size() - 1));
        }
        else if(winner.size() > 1) {
            for(int i = 0; i < winner.size() - 1; i++) {
                System.out.printf("%s,",winner.get(i));
            }
            System.out.printf("%s가 우승했습니다.", winner.get(winner.size() - 1));
        }
    }
}