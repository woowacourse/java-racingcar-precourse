package racingcar;

import java.util.Scanner;

// 클라로부터 입력 받는 클래스
public class InputView {

    // 필드로 선언하고 생성자에서 초기화
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    // 자동차 이름 입력 메소드
    public String inputCarName() {

        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,), 기준으로 구분): ");
        String input = scanner.nextLine();

        if (input.split(",").length == 0) {
            throw new IllegalArgumentException("[ERROR] 두 대 이상의 자동차를 입력하세요.");
        }
        return input;
    }

    // 시도 횟수 입력 메소드
    public int inputCount() {

        System.out.println("시도할 횟수를 입력하세요.");
        int count = scanner.nextInt();

        if (count <= 0) {
            throw new IllegalArgumentException("[ERROR] 1회 이상 입력하세요.");
        }
        return inputCount();
    }
}
