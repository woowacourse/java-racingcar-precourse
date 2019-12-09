import java.util.Scanner;

public class Game {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        Car[] cars;
        String input;
        String[] names;
        int numberOfGames, numberOfCars;

        names = processInputText();
        if(names == null)   return;
        System.out.println("시도할 회수는 몇회인가요?");
        numberOfGames = s.nextInt();
        numberOfCars = names.length;
        cars = new Car[numberOfCars];
        initializeCar(cars, names, numberOfCars);
        printGame(cars, numberOfGames, numberOfCars);
    }
    public static String[] processInputText(){
        String input;
        String[] names;

        System.out.println("경주할 자동차 이름을 입력하세요, (이름은 쉼표(,) 기준으로 구분)");
        input = s.nextLine();
        names = input.split(",");
        for(int i=0;i<names.length;i++){
            if(names[i].length()>5){
                System.out.println("자동차 이름은 5자 이하가 되어야 합니다.");
                return null;
            }
        }
        return names;
    }
    public static void initializeCar(Car[] cars, String[] names,
                                     int numberOfCars){
        for(int i=0;i<numberOfCars;i++){
            cars[i] = new Car(names[i]);
        }
    }
    public static void printGame(Car[] cars, int numberOfGames,
                                 int numberOfCars){
        int[] movingCounter = new int[numberOfCars];

        System.out.println("\n실행 결과");
        for(int i=0;i<numberOfGames;i++){
            for(int j=0;j<numberOfCars;j++){
                movingCounter[j] += cars[j].printMovingForward();
            }
            System.out.println();
        }
        printWinner(cars, movingCounter);
    }
    public static void printWinner(Car[] cars, int[] movingCounter){
        int maxMovingCounter = movingCounter[0];
        int numberOfWinner = 0;
        String tmp = "";

        for(int i=0;i<movingCounter.length;i++){
            if(movingCounter[i]>maxMovingCounter){
                maxMovingCounter = movingCounter[i];
            }
        }
        for(int i=0;i<movingCounter.length;i++){
            if(movingCounter[i] == maxMovingCounter){
                tmp+=cars[i].toString()+", ";
            }
        }
        System.out.println(tmp.substring(0, tmp.length()-2)+"가 최종 우승했습니다.");
    }
}