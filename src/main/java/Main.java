import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Scanner;

import domain.Car;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = sc.nextLine().split(",");
        int countofCar = carNames.length;

        System.out.println("시도할 회수는 몇회인가요?");
        int count = sc.nextInt();

        Car[] cars = new Car[countofCar];

        for (int i=0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

        for (int k=0; k < count; k++) {
            for (int i = 0; i < cars.length; i++) {
                if (Math.random() * 10 > 3) cars[i].position += 1;
                System.out.print(cars[i].name);
                System.out.print(" : ");
                for (int j=0; j < cars[i].position; j++) System.out.print("-");
                System.out.println();
            }
            System.out.println();
        }

        int maxPosition = 0;
        for (int i=0;i < cars.length; i++) {
            if (cars[i].position > maxPosition) {
                maxPosition = cars[i].position;
            }
        }
        String winners = "";
        for (int i=0; i < cars.length; i++) {
            if (cars[i].position == maxPosition) {
                if (winners != "") winners += ", ";
                winners += cars[i].name;
            }
        }
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
