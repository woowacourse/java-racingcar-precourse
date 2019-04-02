package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {

    private Scanner sc;
    private String[] inputString;

    public String[] getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기분으로 구분)");
        sc = new Scanner(System.in);
        inputString = sc.nextLine().split(",");
        for (int i = 0; i < inputString.length; i++) {
            inputString[i] = inputString[i].replaceAll(" ", "");
        }
        return inputString;
    }

    public int getTrialNums() {
        System.out.println("시도할 회수는 몇회인가요?");
        sc = new Scanner(System.in);
        int trialNums = sc.nextInt();
        System.out.println();
        return trialNums;
    }

    public void showResults(Car car) {
        int position = car.getPosition();
        System.out.print(car.getName() + ":");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public void showWinners(ArrayList<String> ans) {
        if (ans.size() != 1) {
            for (int i = 0; i < ans.size() - 1; i++) {
                System.out.print(ans.get(i) + ". ");
            }
        }
        System.out.println(ans.get(ans.size() - 1) + "이/가 최종 우승했습니다.");
    }
}
