package xyz.zerobell;

import java.util.Scanner;

public class Main {

    static private Scanner sc;

    static private Scanner getScanner() {
        if (sc==null) {
            sc = new Scanner(System.in);
        }

        return sc;
    }

    static private String[] separateStrings(String str) {
        return str.split(",");
    }

}
