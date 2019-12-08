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
}
