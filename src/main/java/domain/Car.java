/*
 * Class:   Car
 *
 * Version: 1.0
 *
 * Date:    2019-12-10
 *
 * Author:  Jae Bin Lee
 *
 */
package domain;
import java.util.*;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private static String getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner sc = new Scanner(System.in);
        String names = sc.nextLine();
        return names;
    }

    private static Car[] parseName(String names) {
        String[] carsName = names.split(",");
        int carCount=carsName.length;
        checkCarsName(carsName);

        Car[] car = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            car[i] = new Car(carsName[i]);
        }
        return car;
    }

    public static void checkCarsName(String[] carsName){
        int carCount=carsName.length;
        for(int i=0;i<carCount;i++){
            if(carsName[i].length()>5){
                throw new RuntimeException();
            }
        }
    }

    public static Car[] initCars() {
        Car[] cars;
        String names;

        names = Car.getNames();
        cars = Car.parseName(names);
        return cars;
    }

    public void printResult() {
        String moveCount = "";
        for (int i = 0; i < this.position; i++) {
            moveCount += "-";
        }
        System.out.println(this.name + " : " + moveCount);
    }

    public static int getGameCount() {
        int gameCount;
        System.out.println("시도할 횟수는 몇회인가요?");
        Scanner sc = new Scanner(System.in);
        gameCount = sc.nextInt();
        return gameCount;
    }

    public void moveCar() {
        Random random = new Random();
        int randomNum = random.nextInt(10);
        if (randomNum > 4) {
            this.position += randomNum;
        }
    }


    public static void printFinalResult(Car[] cars) {
        String finalResult="";
        finalResult=getFinalResult(cars);
        System.out.println(finalResult + "가 최종 우승했습니다.");
    }

    public static String getFinalResult(Car[] cars){
        String finalResult="";
        List<Integer> winnerIndexList;
        int winnerIndex=-1;

        winnerIndexList=getWinnerIndexList(cars);
        winnerIndex=winnerIndexList.get(0);
        finalResult+=cars[winnerIndex].name;
        for(int i=1;i<winnerIndexList.size();i++){
            finalResult+=","+cars[winnerIndexList.get(i)].name;
        }

        return finalResult;
    }

    public static List<Integer> getWinnerIndexList(Car[] cars) {
        int winnerPosition;
        List<Integer> winnerIndexList=new ArrayList<Integer>();
        winnerPosition=findWinnerPosition(cars);

        for(int i=0;i<cars.length;i++){
            int carPosition=cars[i].position;
            if(winnerPosition==carPosition){
                winnerIndexList.add(i);
            }
        }

        return winnerIndexList;
    }

    public static int findWinnerPosition(Car[] cars) {
        int winnerPosition = -1;
        for(int i=0;i<cars.length;i++){
            int carPosition=cars[i].position;
            if(winnerPosition<carPosition){
                winnerPosition=carPosition;
            }
        }
        return winnerPosition;
    }

    public static Map<String, Integer> getRankMap(Car[] cars) {
        Map<String, Integer> rank = new HashMap<String, Integer>();
        for (int i = 0; i < cars.length; i++) {
            rank.put(cars[i].name, cars[i].position);
        }
        return rank;
    }
}
