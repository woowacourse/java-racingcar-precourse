package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }
    public String getName() {
        return this.name;
    }
    public static Car[] getCarName() {
        boolean isNameLengthValidate = true;
        String carNames = "";
        while (isNameLengthValidate) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = Console.readLine();
            isNameLengthValidate = validateNameLength(carNames);
        }
        return splitCars(carNames);
    }

    private static Car[] splitCars(String carNames) {
        String[] cars = carNames.split(",");
        Car[] car = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            car[i] = new Car(cars[i]);
        }
        return car;
    }

    public void move() {
        this.position += 1;
    }

    public void printPosition() {
        for (int i = 0; i < position ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printCarName() {
        System.out.print(this.name + " : ");
    }

    private static boolean validateNameLength(String str) {
        try{
            Utils.isEachStringOverLength(str);
        }catch (Exception e) {
            System.out.println("[ERROR] 이름은 5자 이하여야합니다.");
            return true;
        }
        return false;
    }
}
