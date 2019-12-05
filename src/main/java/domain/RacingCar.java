package domain;
import java.util.*;

public class RacingCar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count;
        String carName;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carName = sc.nextLine();

        System.out.println("시도할 회수는 몇회인가요?");
        count = sc.nextInt();

        Game.gameStart(carName, count);
    }
}