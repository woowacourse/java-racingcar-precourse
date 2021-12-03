package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Race {
    private static ArrayList<Car> cars = new ArrayList<>();
    private static ArrayList<Car> winnerCars = new ArrayList<>();
    private static int moveCount;
    public static int maxDistance;


    public static String getUserInput() {
        return Console.readLine();
    }

    public static void getCarByName() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String userInput = getUserInput();
            String[] carNames = userInput.split(",");
            for (String carName : carNames) {
                if (carName.length() > 5) {
                    throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
                }
                Car car = new Car(carName);
                cars.add(car);
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            getCarByName();
        }
    }

    public static void getMoveCount() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String userInput = getUserInput();
            if(!userInput.chars().allMatch(Character::isDigit)){
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
            }
            moveCount = Integer.parseInt(userInput);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            getMoveCount();
        }
    }

    public void run() {
        getCarByName();
        getMoveCount();
        System.out.println();
        System.out.println("실행 결과");
        while (moveCount > 0) {
            for (Car car : cars) {
                car.move();
                car.printPosition();
            }
            System.out.println();
            moveCount--;
        }
        calculateMaxDistance();
        decideWinner();
        printWinner();
    }

    public void calculateMaxDistance() {
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getPosition());
        }
    }

    public void decideWinner() {
        for (Car car : cars) {
            if (car.getPosition() == maxDistance) {
                winnerCars.add(car);
            }
        }
    }

    public void printWinner() {
        int winnerCount = winnerCars.size();
        String[] winnerCarNames = new String[winnerCount];
        for (int i = 0; i < winnerCount; i++) {
            winnerCarNames[i] = winnerCars.get(i).getName();
        }
        System.out.println("최종 우승자 : " + String.join(", ", winnerCarNames));
    }

}
