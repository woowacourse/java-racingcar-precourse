
import java.util.*;

public class Game {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String input;
        String[] names;
        int numberOfGames;
        Car[] cars;

        System.out.println("경주할 자동차 이름을 입력하세요," +
                " (이름은 쉼표(,) 기준으로 구분)");
        input = s.nextLine();
        names = input.split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        numberOfGames = s.nextInt();

        cars = new Car[numberOfGames];
        System.out.println("실행 결과");
        for(int i=0;i<names.length;i++){
            cars[i] = new Car(names[i]);
        }
        for(int i=0;i<numberOfGames;i++){
            cars[0].printMovingForward();
            System.out.println();
        }

    }

}