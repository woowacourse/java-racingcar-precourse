package domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingManager {
    private Scanner sc = new Scanner(System.in);

    public List<String> inputCarNames() {
        List<String> carNames;
        Validator validator = new Validator();

        do {
            System.out.println("경주할 자동차 이름을 입력하세요. 이름은 쉼표를 기준으로 구분합니다.");
            carNames = Arrays.stream(sc.nextLine().split(","))
                    .map(name -> name.trim()) //이름 앞뒤로 whitespace 제거
                    .filter(name -> !name.equals("")) //비어있는 이름 제거
                    .collect(Collectors.toList());
        } while (validator.hasInvalid(carNames));
        return carNames;
    }

    public ArrayList<Car> getInitializedCars() {
        ArrayList<Car> cars = new ArrayList<>();
        List<String> carNames = inputCarNames();

        for (String name: carNames) {
            if (!name.isEmpty()) {
                cars.add(new Car(name));
            }
        }
        return cars;
    }

    public int getTotalTrial() {
        String totalTrial;
        Validator validator = new Validator();

        do {
            System.out.println("시도할 회수는 몇회인가요?");
            totalTrial = sc.nextLine();
        } while (!validator.isNumber(totalTrial));
        return Integer.parseInt(totalTrial);
    }
}