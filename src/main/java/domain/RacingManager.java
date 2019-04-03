package domain;

import java.util.*;

public class RacingManager {
    private Scanner sc = new Scanner(System.in);

    public String[] inputCarNames() {
        String[] carNames;
        Validator validator = new Validator();

        do {
            System.out.println("경주할 자동차 이름을 입력하세요. 이름은 쉼표를 기준으로 구분합니다.");
            carNames = sc.nextLine().split("[\\s]*,[\\s]*");
        } while(validator.hasInvalid(carNames));
        return carNames;
    }

    public ArrayList<Car> getInitializedCars() {
        ArrayList<Car> cars = new ArrayList<>();
        String[] carNames = inputCarNames();

        for (String name: carNames) {
            if (!name.isEmpty()) {
                cars.add(new Car(name));
            }
        }
        return cars;
    }

    public int getTotalTrial() {
        int totalTrial;

        System.out.println("시도할 회수는 몇회인가요?");
        while (true) {
            try {
                totalTrial = sc.nextInt();
                return totalTrial;
            } catch (InputMismatchException e) {
                System.out.print("숫자만 입력해 주세요: ");
                sc = new Scanner(System.in);
            }
        }
    }

    public void sendMoveSignalsTo(ArrayList<Car> cars) {
        for (Car car: cars) {
            car.randomMove();
        }
    }
}