package View;

import domain.Car;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RacingCar {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
            racingGame.inputCarName();

            System.out.println("시도할 회수는 몇회인가요?");
            int count = sc.nextInt();

            System.out.println("\n시행 결과");
            for (int i = 0; i < count; i++) {
                racingGame.play();
                racingGame.displayCarPosition();
                System.out.println();
            }

            List<Car> carList = racingGame.getResult();
            for (int i = 0; i < carList.size(); i++) {
                System.out.print(carList.get(i).getName());
                if ( i != carList.size()-1) {
                    System.out.print(", ");
                }

            }
            System.out.println("가 최종 우승했습니다.");

        } catch (InputMismatchException e) {
            System.out.println("숫자가 아닙니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

