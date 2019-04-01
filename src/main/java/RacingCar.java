import java.util.Scanner;

public class RacingCar {

    public static String[] inputCarName() {
        Scanner sc = new Scanner(System.in);
        String carNames = sc.nextLine();
        String[] splitCarName = carNames.split(",");
        return splitCarName;
    }

    public static boolean namingRule(String[] carNames) {
        for (String name: carNames) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] carNames = inputCarName();
        System.out.println(namingRule(carNames));
    }

}
