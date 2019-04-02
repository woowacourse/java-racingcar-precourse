package domain;

import java.util.Scanner;

/**
 * Config : 자동차 게임을 위한 메소드르 담은 클래스
 * Sort : alphabetically
 */
public class Config {

    static final int LIMIT_TOP_NAME_NUMBER = 5;
    static final int LIMIT_LOW_NAME_NUMBER = 1;

    public String characterMultiple(char value, int count) {
        String position = "";
        for (int i = 0; i < count; i++) {
            position = position + value;
        }
        return position;
    }

    public Boolean checkNameNumber(String[] nameArray) {
        for (int i = 0; i < nameArray.length; i++) {
            if ((nameArray[i].length() > LIMIT_TOP_NAME_NUMBER)
                    || (nameArray[i].length() < LIMIT_LOW_NAME_NUMBER)) {
                return false;
            }
        }
        return true;
    }

    public int findMaxPosition(Car[] garage) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < garage.length; i++) {
            if (garage[i].getPosition() >= max) {
                max = garage[i].getPosition();
            }
        }
        return max;
    }

    public String inputCarsName() {
        Scanner scan = new Scanner(System.in);
        String cars = scan.nextLine();
        return cars;
    }

    public String[] loopIfNotOneToFive(String[] carsArray) {
        Boolean checkName = checkNameNumber(carsArray);
        if (!checkName) {
            System.out.println("이름은 1자 이상 5자 이하로 입력해주세요.");
            carsArray = divideCarNameArray(inputCarsName());
            loopIfNotOneToFive(carsArray);
        }
        return carsArray;
    }

    public String[] makeArrayByString(String name) {
        String[] nameArray = name.split(",");
        return nameArray;
    }

    public String[] divideCarNameArray(String name) {
        String cars = name;
        String[] carsArray = makeArrayByString(cars);
        carsArray = loopIfNotOneToFive(carsArray);
        return carsArray;
    }

    /**
     * Garage는 차고로써 Car의 인스턴스들을 담는다.
     * @param carArrays
     * @return Car인스턴스를 담은 배열
     */
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

    /**
     * 자동차 레이스 시에 경기 상황을 중계(출력)한다.
     * @param garage
     * @param i
     */
    public void printRaceRelay(Car[] garage, int i) {
        String counter = characterMultiple('-', garage[i].getPosition());
        System.out.println(garage[i].getName() + ": " + counter);
    }

    public String printWinner(Car[] garage) {
        String winner = "";
        int max = findMaxPosition(garage);
        for (int i = 0; i < garage.length; i++) {
            if (max == garage[i].getPosition()) {
                winner = winner + garage[i].getName() + ",";
            }
        }
        winner = winner.substring(0, winner.length() - 1);
        return winner;
    }

    public Car[] race(Car[] garage) {
        int random;
        for (int i = 0; i < garage.length; i++) {
            random = makeRandom();
            if (random > 4) {
                garage[i].movePosition();
            }
            printRaceRelay(garage, i);
        }
        System.out.println("");
        return garage;
    }
}
