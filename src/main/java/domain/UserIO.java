package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class UserIO {
    private static Scanner sc;

    public UserIO() {
        sc = new Scanner(System.in);
    }

    /* 사용자로부터 자동차 이름 입력 받기, 각 이름이 조건 불만족 시 다시 입력 받음*/
    public String[] getName() {
        String[] names;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분\n>>");
            String input = sc.nextLine();

            final String delimiter = ",";   //  쉼표 기준으로 파싱
            names = input.split(delimiter);
            int length = names.length;

            for (int i = 0; i < length; i++) {  //  공백 제거
                names[i] = names[i].trim();
            }
        } while (!checkName(names));
        return names;
    }

    /* 각 이름의 길이가 조건 만족하는지 검증 */
    public boolean checkName(String[] names) {
        final int maxLength = 5;
        ArrayList<String> errorList = new ArrayList<>();
        for (String it : names) {
            if (it.length() > maxLength) {
                errorList.add(it);
            }
        }

        if (errorList.isEmpty()) {
            return true;
        }

        checkNameErrorMsg(errorList);
        return false;
    }

    /* 입력 조건을 초과한 잘못된 입력들을 모아 출력 */
    public void checkNameErrorMsg(ArrayList<String> errorList) {
        System.out.print("각 자동차 이름은 5자 이하로 입력해주세요. ");
        for (String it : errorList) {
            System.out.print(it + " ");
        }
        System.out.println("에서 오류 발생");
    }

    /* 게임 횟수 입력 받기 */
    public int getTimes() {
        System.out.print("시도할 횟수는 몇회인가요?");
        System.out.print(">> ");
        return sc.nextInt();
    }

    /* 반복 결과 출력 */
    public void printIteration(Car[] carArray) {
        for (Car it : carArray) {
            System.out.print(it.getName() + ": ");
            for (int i = 0; i < it.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    /* 우승자 출력 */
    public void printWinner(ArrayList<Car> winner) {
        for (Car it : winner) {
            System.out.print(it.getName() + " ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
