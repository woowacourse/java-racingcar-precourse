package domain;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class User {
    private Scanner scanner;
    public User(){
        scanner = new Scanner(System.in);
    }

    public String inputTryCount(){
        String input;
        input = scanner.next();
        return input;
    }

    public Vector<Car> inputCarName(){
        String input;
        input = scanner.next();
        return tokenize(input);
    }

    public Vector<Car> tokenize(String input){
        Vector<Car> carList = new Vector<Car>();
        StringTokenizer token = new StringTokenizer(input, ",");
        while(token.hasMoreTokens()){
            carList.add(new Car(token.nextToken()));
        }
        return carList;
    }
}
