package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void Move(boolean goStop) {
        if (goStop) {
            position++;
        }
    }

    public void PrintStatus() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int ReturnStatus() {
        return position;
    }

    public String ReturnName() {
        return name;
    }

    public static Car[] arrayCarObj(String[] arrayCar) {
        Car[] arrayCarObj = new Car[arrayCar.length];
        for (int i = 0; i < arrayCar.length; i++) {
            arrayCarObj[i] = new Car(arrayCar[i]);
        }
        return arrayCarObj;
    }

    public static boolean GoOrStop() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
