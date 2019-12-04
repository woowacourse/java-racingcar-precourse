package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
        List<Car> carsList = inputCarNames();
        startRace(carsList, getTurnNumber());
        printWinner(carsList);
    }

    private static void printWinner(List<Car> carsList) {
        int maxScore = 0;
        for(Car oneCar: carsList) {
            int thisCarPosition = oneCar.getPosition();
            if (thisCarPosition > maxScore) {
                maxScore = thisCarPosition;
            }
        }
    }

    private static void startRace(List<Car> carsList, int turnNumber) {
        System.out.println("실행 결과");
        for(int i = 0; i < turnNumber; i++) {
            playOneTurn(carsList);
        }
    }

    private static void playOneTurn(List<Car> carsList) {
        for(Car oneCar : carsList) {
            oneCar.playTurn();
        }
        System.out.println();
    }

    private static int getTurnNumber() {
        int turnNumber = 0;
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("시도할 횟수는 몇 회인가요?");
            turnNumber = scan.nextInt();
            if(turnNumber > 0 ) {
                break;
            }
            System.out.println("다시 입력해 주세요.");
        }
        return turnNumber;
    }

    private static List<Car> inputCarNames() {
        String carNames;
        List<Car> carsList;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = scan.nextLine();
            carsList = enrollPlayers(carNames);
            if (carsList != null) {
                return carsList;
            }
            System.out.println("다시 입력해 주세요.");
        }
    }
    
    

    private static List<Car> enrollPlayers(String carNames) {
        String[] carArray = carNames.split(",");
        List<Car> carsList = new ArrayList<Car>();
        for (String oneCar : carArray) {
            if(!verifyCarName(oneCar)) {
                return null;
            }
            carsList.add(new Car(oneCar));
        }
        return carsList;
    }

    private static boolean verifyCarName(String carName) {
        if(carName.length() > 5 || carName.length() == 0) {
            return false;
        }
        return true;
    }
}

