package domain;

import java.util.Scanner;

public class InputCar {
    String carName = "";
    String[] carNameList = {""};
    Car[] carArr;


    void scanCar() {
        Scanner scan = new Scanner(System.in);
        carName = scan.next();
        carNameList = carName.split(",");
        checkCarName();
    }

    void checkCarName() {
        for (int i = 0; i < carNameList.length; i++) {
            if (carNameList[i].length() > 5) {
                System.out.println("자동차의 이름은 5자까지만 가능합니다. 다시 입력해주세요.");
                scanCar();
            }
        }
    }

    void setCar() {
        int length = carNameList.length;
        carArr = new Car[length];

        for (int i = 0; i < length; i++) {
            carArr[i] = new Car(carNameList[i]);
        }
    }
}
