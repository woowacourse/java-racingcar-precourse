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
        int turnNumber = inputTurn();
        System.out.println("턴 수: "+turnNumber);
        for(int i = 0; i < carsList.size(); i++) {
            carsList.get(i).proceed();
        }
    }

    private static int inputTurn() {
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
        for (int i = 0; i < carArray.length; i++) {
            if(!verifyCarName(carArray[i])) {
                return null;
            }
            carsList.add(new Car(carArray[i]));
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

