package domain;

import java.util.*;

public class GameManager {

    public int numOfCars;
    public int numOfRounds;
    public int randomRange;
    public String delimiter;
    public Car[] cars;

    public static void main(String[] args) {
        GameManager game = new GameManager();
        game.delimiter = ",";
        game.randomRange = 10;
        game.startGame();

        for (int i = 0; i < game.numOfRounds; i++) {
            System.out.println("실행결과");
            game.playGame();
        }
        game.printFinalWinner();
    }

    void startGame() {
        String carNames = getCarNames();
        while (!setCarName(carNames)) {
            carNames = getCarNames();
        }
        getNumOfRounds();
    }

    String getCarNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = sc.nextLine();
        while (carNames.isEmpty()) {
            carNames = getCarNames(false);
        }
        return carNames;
    }

    String getCarNames(boolean wrongInput) {
        System.out.println("1개 이상의 자동차 이름을 입력해 주세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner sc = new Scanner(System.in);
        String carNames = sc.nextLine();
        return carNames;
    }

    boolean setCarName(String input) {
        if (input == null) {
            return false;
        }
        String[] carNameArray = input.split(delimiter);
        numOfCars = carNameArray.length;
        cars = new Car[numOfCars];

        for (int i = 0; i < numOfCars; i++) {
            String carName = carNameArray[i];
            if (carName.length() > 5) {
                System.out.println("이름은 5자 이내로 작성해 주세요. 다시 입력");
                return false;
            }
            cars[i] = new Car(carName);
        }
        return true;
    }

    void getNumOfRounds() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 횟수는 얼마인가요?");
        numOfRounds = sc.nextInt();
    }

    void playGame() {
        for (int carNum = 0; carNum < numOfCars; carNum++) {
            int randomNumber = getRandomNumber();
            checkGoStop(carNum, randomNumber);
            printCurrentPosition(carNum);
        }
        System.out.println();
    }

    int getRandomNumber() {
        Random r = new Random();
        int randomNum = r.nextInt(randomRange);
        return randomNum;
    }

    void checkGoStop(int carNum, int randomNumber) {
        if (randomNumber >= 4) {
            cars[carNum].go();
            return;
        }
        if (randomNumber <= 3) {
            cars[carNum].stop();
            return;
        }
    }

    void printCurrentPosition(int carNum) {
        System.out.print(cars[carNum].getName() + ": ");
        for (int i = 0; i < cars[carNum].getPosition(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    void printFinalWinner() {
        ArrayList<Integer> finalPositionArray = new ArrayList<Integer>();
        for (int i = 0; i < numOfCars; i++) {
            finalPositionArray.add(cars[i].getPosition());
        }
        int maxPosition = Collections.max(finalPositionArray);

        printMaxPositionNames(maxPosition);
        System.out.println("가 최종 우승했습니다.");
    }

    void printMaxPositionNames(int maxPosition) {
        ArrayList<String> maxPositionNameList = new ArrayList<String>();
        for (int i = 0; i < numOfCars; i++) {
            if (cars[i].getPosition() == maxPosition) {
                maxPositionNameList.add(cars[i].getName());
            }
        }
        for (int i = 0; i < maxPositionNameList.size() - 1; i++) {
            System.out.print(maxPositionNameList.get(i) + ", ");
        }
        System.out.print(maxPositionNameList.get(maxPositionNameList.size() - 1));
    }

}
