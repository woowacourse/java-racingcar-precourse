package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import constants.SystemMessage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static List<String> getCarName(){
        System.out.println(SystemMessage.INPUT_CARNAME);
        String carName = Console.readLine();
        List<String> parsedCarName = parseCarName(carName);
        return parsedCarName;
    }

    private static List<String> parseCarName(String carName) {
        String[] parsedArrCarName = carName.split(",");
        List<String> parsedListCarName = new ArrayList<>(Arrays.asList(parsedArrCarName));
        checkCarName(parsedListCarName);
        return parsedListCarName;
    }

    private static void checkCarName(List<String> parsedListCarName) {
        for(String carName: parsedListCarName){
            if(carName.length()>5){
                throw new IllegalArgumentException();
            }
        }
    }

    public static int getTurnNumber(){
        System.out.println(SystemMessage.INPUT_TURN_NUMBER);
        String stringTurnNumber = Console.readLine();
        checkCarTurn(stringTurnNumber);
        int turnNumber = Integer.parseInt(stringTurnNumber);
        return turnNumber;
    }

    private static void checkCarTurn(String stringTurnNumber) {
        for(int i=0; i<stringTurnNumber.length(); i++){
            if(!Character.isDigit(stringTurnNumber.charAt(i))){
                throw new IllegalArgumentException();
            }
        }
    }

    public static void getFinalResult(List<Car> carList){
        int maxCarPosiiton = getMaxCarPosition(carList);
        List<Car> winnerCar = getWinnerCar(carList, maxCarPosiiton);
        getFinalMessage(winnerCar);
    }

    private static String getFinalMessage(List<Car> winnerCar) {
        if(winnerCar.size()==1){
            // 단독 우승
            System.out.println(SystemMessage.OUTPUT_ONE_WINNER + " : " + Car.getCarName(winnerCar.get(0)));
        } else {
            // 공동 우승
            String multiCarName = getMultiWinnerName(winnerCar);
            System.out.println(SystemMessage.OUTPUT_MULTI_WINNER + " : " + multiCarName);
        }
        return null;
    }

    private static String getMultiWinnerName(List<Car> winnerCar) {
        String nameString = Car.getCarName(winnerCar.get(0));
        for(int i=1; i<winnerCar.size()-1; i++){
            nameString = nameString + ", " + Car.getCarName(winnerCar.get(i));
        }
        nameString = nameString + ", " + Car.getCarName(winnerCar.get(winnerCar.size()-1));
        return nameString;
    }

    private static List<Car> getWinnerCar(List<Car> carList, int maxCarPosiiton) {
        List<Car> winnerCar = new ArrayList<Car>();
        for(Car car: carList){
            if(maxCarPosiiton==Car.getCarPosition(car)){
                winnerCar.add(car);
            }
        }
        return winnerCar;
    }

    private static int getMaxCarPosition(List<Car> carList) {
        int maxCarPosition = -1;
        for(Car car: carList){
            maxCarPosition = Math.max(Car.getCarPosition(car), maxCarPosition);
        }
        return maxCarPosition;
    }


}
