package utils;

import racingcar.Car;
import racingcar.GameManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManager {
    public int carCount;

    public ArrayList<Car> scanCarNames(Scanner scanner) {
        String[] carNames;
        ArrayList<Car> cars = new ArrayList<>();
        System.out.println(Sentences.ASK_CAR_NAME);
        while(true) {
            try{
                carNames = scanner.nextLine().trim().split(",");
                checkCarNames(carNames);
                break;
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public int scanRound(Scanner scanner) {
        String input;
        int round;
        System.out.println(Sentences.ASK_TRACK_LENGTH);
        while(true) {
            try{
                input = scanner.nextLine().trim();
                checkRound(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        round = Integer.parseInt(input);
        return round;
    }

    private void checkCarNames(String[] carNames) {
        for(String carName : carNames) {
            if(carName.length() > GameManager.MAXIMUM_CARNAME_LENGTH) {
                throw new IllegalArgumentException(Sentences.MAXIMUM_CARNAME_LENGTH_ERROR);
            }
        }
    }

    private void checkRound(String round) {
        char temp;
        for(int i = 0; i < round.length(); i++) {
            temp = round.charAt(i);
            if(!Character.isDigit(temp)) {
                throw new IllegalArgumentException(Sentences.ROUND_INPUT_ERROR);
            }
        }
    }
}
