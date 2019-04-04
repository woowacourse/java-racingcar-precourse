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

    /**
     * 자동차의 이름들이 적혀 있는 문자열 input을 문자 "," 기준으로
     * 문자열을 분리하여 carList에 저장한다.
     * @param input
     * @return vector<Car>
     */
    public Vector<Car> tokenize(String input){
        Vector<Car> carList = new Vector<Car>();
        StringTokenizer token = new StringTokenizer(input, ",");
        while(token.hasMoreTokens()){
            carList.add(new Car(token.nextToken()));
        }
        return carList;
    }
}
