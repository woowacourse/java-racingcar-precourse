package domain;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class User {
    private Scanner scanner;
    private Vector<String> carList;
    public User(){
        scanner = new Scanner(System.in);
    }

    public Vector<String> inputCarName(){
        String input;
        input = scanner.next();
        return tokenize(input);
    }

    public Vector<String> tokenize(String input){
        Vector<String> carList = new Vector<String>();
        StringTokenizer token = new StringTokenizer(input, ",");
        while(token.hasMoreTokens()){
            carList.add(token.nextToken());
        }
        return carList;
    }
}
