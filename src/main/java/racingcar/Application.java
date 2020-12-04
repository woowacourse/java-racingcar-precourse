package racingcar;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String carsInput = scanner.next();
        String[] cars = carsInput.split(",");
        System.out.println(Arrays.toString(cars));
    }
}
