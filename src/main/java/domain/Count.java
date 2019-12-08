package domain;

import java.util.Scanner;

public class Count {
    static int inputCount() {
        int count = 0;
        String countString = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            countString = sc.nextLine();
        } while (checkCount(countString));
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
        if (Integer.parseInt(count) == 0 || Double.parseDouble(count) > Integer.MAX_VALUE) {
            System.out.println("숫자는 0보다 크고 2,147,483,648보다 작아야합니다.");
            return again;
        }
        again = false;
        return again;
    }
}
