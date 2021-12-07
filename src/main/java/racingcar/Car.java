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

    public static Car[] getNamesFromUser() {
        boolean isNameValid = false;
        String NamesInLine = "";
        while (!isNameValid) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            NamesInLine = Console.readLine();
            isNameValid = validateName(NamesInLine);
        }
        return makeCarInstance(NamesInLine);
    }

    private static Car[] makeCarInstance(String NamesInLine) {
        String[] names = NamesInLine.split(",");
        Car[] car = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            car[i] = new Car(names[i]);
        }
        return car;
    }

    public void move() {
        this.position += 1;
    }

    public void printPosition() {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printCarName() {
        System.out.print(this.name + " : ");
    }

    private static boolean validateName(String NamesInLine) {
        try {
            Utils.validateLength(NamesInLine);
        } catch (Exception e) {
            System.out.println("[ERROR] 이름은 1자 이상, 5자 이하여야합니다.");
            return false;
        }
        return true;
    }
}
