package domain;

import java.util.Scanner;

public class Config {

    public String[] splitName(String name) {
        String[] nameArray = name.split(",");
        return nameArray;
    }

    public Boolean checkNameNumber(String[] nameArray) {
        for (int i = 0; i < nameArray.length; i++) {
            if (nameArray[i].length() > 5 ||nameArray[i].length() ==0) {
                return false;
            }
        }
        return true;
    }

    public Car[] makeGarage(String[] carArrays) {
        int length = carArrays.length;
        Car[] garage = new Car[length];
        for (int i = 0; i < length; i++) {
            garage[i] = new Car(carArrays[i]);
        }
        return garage;
    }

    public int makeRandom() {
        double Random = Math.random() * 10;
        int random = (int) Random;
        return random;
    }

    public void race(Car[] garage) {
        int random;
        for (int i = 0; i < garage.length; i++) {
            random = makeRandom();
            if (random > 4) {
                garage[i].movePosition();
            }
        }
    }

    public String printWinner(Car[] garage) {
        String winner = "";
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < garage.length; i++) {
            if (garage[i].getPosition() >= max) {
                max = garage[i].getPosition();
                winner = winner + garage[i].getName() + ",";
            }
        }
        winner = winner.substring(0, winner.length() - 1);
        return winner;
    }

    public String[] loopIfNotFiveLess() {
        Scanner scan = new Scanner(System.in);
        String cars = scan.next();
        String[] carsArray = splitName(cars);
        Boolean checkName = checkNameNumber(carsArray);
        if (!checkName) {
            System.out.println("이름은 1자 이상 5자 이하로 입력해주세요.");
            carsArray= loopIfNotFiveLess();
        }
        return carsArray;
    }
}
