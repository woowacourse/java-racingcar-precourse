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

    public void inputCarName(){
        String input;
        input = scanner.next();
        tokenize(input);
    }

    public void tokenize(String input){
        carList = new Vector<String>();
        StringTokenizer token = new StringTokenizer(input, ",");
        while(token.hasMoreTokens()){
            carList.add(token.nextToken());
        }
    }
}
