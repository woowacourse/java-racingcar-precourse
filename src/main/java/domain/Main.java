package domain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String names = s.nextLine();

        String[] nameList = names.split(",");
        for (String name : nameList) {
            System.out.print(name + "\t");
        }


    }
}
