package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingManager {
    private Scanner sc = new Scanner(System.in);

    public ArrayList<Car> getInitializedCars() {
        System.out.println("경주할 자동차 이름을 입력하세요. 이름은 쉼표를 기준으로 구분합니다.");
        ArrayList<Car> cars = new ArrayList<>();
        String[] carNames = sc.nextLine().split(",[\\s]*");

        for (String name: carNames) {
            if (!name.isEmpty()) {
                cars.add(new Car(name));
            }
        }
        return cars;
    }

    public int getTotalTrial() {
        System.out.println("시도할 회수는 몇회인가요?");
        int totalTrial = sc.nextInt();
        return totalTrial;
    }

    public void sendMoveSignals(ArrayList<Car> cars) {

    }
}