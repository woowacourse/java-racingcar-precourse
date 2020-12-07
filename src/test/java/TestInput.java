import java.util.Scanner;

public class TestInput {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            try {
                System.out.print("숫자 입력: ");
                int inputNum = scanner.nextInt();
                scanner.nextLine(); // buffer flush
                System.out.print("문자열 입력: ");
                String inputStr = scanner.nextLine();
                System.out.println("입력된 값 확인: " + inputNum + ", " + inputStr);
            } catch (Exception e) {
                System.out.println("[예외 발생] 다시 입력해주세요.");
                scanner.nextLine(); // buffer flush
                i--;
            }
        }
    }
}
