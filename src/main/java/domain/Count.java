package domain;

import java.util.Scanner;

public class Count {
    static int inputCount() {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String countString = sc.nextLine();
        count = Integer.parseInt(countString);
        return count;
    }

    static boolean checkCount(String count) {
        boolean again = true;
        for (int i = 0; i < count.length(); i++) {
            if (count.charAt(i) < '0' || count.charAt(i) > '9') {
                System.out.println("숫자만 입력해주세요.");
                return again;
            }
        }
        if (Integer.parseInt(count) == 0) {
            System.out.println("1 이상의 수를 입력하세요.");
            return again;
        }
        again = true;
        return again;
    }
}
