import domain.Car;

import java.util.*;

public class RacingCar {

    public Set<String> inputCarName() {
        Scanner sc = new Scanner(System.in);
        String carNames;
        String[] splitCarNames;
        Set<String> distinctCarName = new HashSet<>();
        boolean isNamingRule;

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = sc.nextLine();
            splitCarNames = carNames.split(",");
            isNamingRule = namingRule(splitCarNames);
            if (isNamingRule) {
                Collections.addAll(distinctCarName, splitCarNames);
                break;
            }
        }
        return distinctCarName;
    }

    public boolean namingRule(String[] carNames) {
        for (String name: carNames) {
            if (name.length() > 5) {
                System.out.printf("자동차 이름의 길이는 5입니다(%s: %d).\n", name, name.length());
                return false;
            }
        }
        return true;
    }

    public int moveCount() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public ArrayList<Car> getCarList(Set<String> carNames) {
        ArrayList<Car> carList = new ArrayList<Car>();
        Car car;
        for (String name: carNames) {
            car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

    public void printCar(ArrayList<Car> carList) {
        String carName;
        int carPosition;
        String carProgression;
        for (Car car: carList) {
            carName = car.getName();
            carPosition = car.getPosition();
            carProgression = getCarProgression(carPosition);
            System.out.printf("%s : %s\n", carName, carProgression);
        }
    }

    public String getCarProgression(int carPosition) {
        StringBuilder carProgression = new StringBuilder();
        if (carPosition < 1) { return carProgression.toString(); }
        for (int i = 0; i < carPosition; i++) {
            carProgression.append("-");
        }
        return carProgression.toString();
    }

    public void moveCars(ArrayList<Car> carList) {
        for (Car car: carList) {
            car.move();
        }
    }

    public void main(String[] args) {
//        Set<String> carNames = inputCarName();
//        ArrayList<Car> carList = getCarList(carNames);
//        for (Car car: carList) {
//            System.out.println(car.getName());
//        }
//        String aa = (String) getCarProgression(3);
//        System.out.println(aa);
    }

}
