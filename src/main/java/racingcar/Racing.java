package racingcar;

import java.util.Scanner;

public class Racing {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] nameList=inputCarsNameList(scanner);
        // TODO 구현 진행
    }

    /* 자동차들의 입력받아 쉼표로 구분하여(,) 반환하는 메소드 */
    public static String[] inputCarsNameList(Scanner scanner){
        String namesInput;
        String[] nameList;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        namesInput=scanner.nextLine();
        nameList=namesInput.split(",");
        return nameList;
    }
}
