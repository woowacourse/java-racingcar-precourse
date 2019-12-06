import domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        ArrayList<String> names;

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).");
        input = scanner.next();
        names = getNamesFromInput(input);
        System.out.println(names);
    }

    public static ArrayList<String> getNamesFromInput(String input) {
        ArrayList<String> answer = new ArrayList<String>();
        Collections.addAll(answer, input.split(","));

        return answer;
    }
}
