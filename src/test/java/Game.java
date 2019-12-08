
import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Car[] cars;
        String input;
        String[] names;
        int numberOfGames, numberOfCars;

        System.out.println("경주할 자동차 이름을 입력하세요," +
                " (이름은 쉼표(,) 기준으로 구분)");
        input = s.nextLine();
        names = input.split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        numberOfGames = s.nextInt();
        numberOfCars = names.length;
        cars = new Car[numberOfCars];
        initializeCar(cars, names, numberOfCars);
        printGame(cars, numberOfGames, numberOfCars);
    }

    public static void initializeCar(Car[] cars, String[] names,
                                     int numberOfCars){
        for(int i=0;i<numberOfCars;i++){
            cars[i] = new Car(names[i]);
        }
    }
    public static void printGame(Car[] cars, int numberOfGames,
                                 int numberOfCars){
        System.out.println("\n실행 결과");
        for(int i=0;i<numberOfGames;i++){
            for(int j=0;j<numberOfCars;j++){
                cars[j].printMovingForward();
            }
        }
    }

}