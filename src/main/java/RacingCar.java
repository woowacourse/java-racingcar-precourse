import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RacingCar {

    public static Set<String> inputCarName() {
        Scanner sc = new Scanner(System.in);
        String carNames;
        String[] splitCarNames;
        Set<String> distinctCarName = new HashSet<>();
        boolean isNamingRule;

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = sc.nextLine();
            splitCarNames = carNames.split(",");
            isNamingRule = namingRule(splitCarNames);
            if (isNamingRule) {
                Collections.addAll(distinctCarName, splitCarNames);
                break;
            }
        }
        return distinctCarName;
    }

    public static boolean namingRule(String[] carNames) {
        for (String name: carNames) {
            if (name.length() > 5) {
                System.out.printf("자동차 이름의 길이는 5입니다(%s: %d).\n", name, name.length());
                return false;
            }
        }
        return true;
    }

    public static int moveCount() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Set<String> carNames = inputCarName();
        System.out.println(carNames);
    }

}
