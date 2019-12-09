package com.minuyim.race.utils;

import java.util.Scanner;

public class UserInputs {
    private static Scanner sc = new Scanner(System.in);
    
    public static String input() {
        String userInput = new String();
        userInput = sc.nextLine();
        
        return userInput;
    }
}
