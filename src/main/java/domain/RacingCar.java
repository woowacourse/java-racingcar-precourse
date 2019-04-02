package domain;

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
                printWarningMessage(splitCarNames, distinctCarName);
                break;
            }
        }
        return distinctCarName;
    }

    public void printWarningMessage(String[] splitCarNames, Set<String> distinctCarName) {
        int duplicatedCount;
        StringJoiner duplicatedName = new StringJoiner(", ");
        for (String distinctName: distinctCarName) {
            duplicatedCount = 0;
            for (String carName: splitCarNames) {
                if (carName.equals(distinctName)) {
                    duplicatedCount ++;
                }
            }
            if (duplicatedCount > 1) {
                duplicatedName.add(distinctName);
            }
        }
        if (duplicatedName.length() > 0) {
            System.out.printf("[Warning]중복된 이름(%s)이 발생하였습니다.\n", duplicatedName);
        }
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
        System.out.println();
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

    public void play() {
        Set<String> carNames = inputCarName();
        ArrayList<Car> carList = getCarList(carNames);
        System.out.println("시도할 횟수는 몇회인가요?");
        int count = moveCount();
        for (int i = 0; i < count; i++) {
            moveCars(carList);
            printCar(carList);
        }
        printWinner(carList);
    }

    public void printWinner(ArrayList<Car> carList) {
        int maxPosition = getMaxPosition(carList);
        int carPosition;
        String carName;
        StringJoiner winnerName = new StringJoiner(", ");
        for (Car car: carList) {
            carPosition = car.getPosition();
            carName = car.getName();
            if (carPosition == maxPosition) {
                winnerName.add(carName);
            }
        }
        System.out.printf("%s가 최종 우승했습니다.\n", winnerName);
    }

    public int getMaxPosition(ArrayList<Car> carList) {
        int maxPosition = 0;
        int carPosition;
        for (Car car: carList) {
            carPosition = car.getPosition();
            maxPosition = Math.max(maxPosition, carPosition);
        }
        return maxPosition;
    }

}
