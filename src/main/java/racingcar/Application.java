package racingcar;


import java.util.Arrays;
import java.util.Scanner;

public class Application {
    static String[] cars;
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carsInput = scanner.next();
            cars = carsInput.split(",");
            System.out.println(Arrays.toString(cars));
        } while (!validCarNameList());

    }

    private static boolean validCarNameList() {
        CarValidator carValidator = new CarValidator();
        for (String carName : cars) {
            if(!carValidator.isValid(carName)) {
                System.out.println("자동차 이름은 5자 이하로 입력하세요.");
                return false;
            }
        }
        return true;
    }

}
