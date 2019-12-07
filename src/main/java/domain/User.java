package domain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class User {

    public String inputCar() {
	Scanner sc = new Scanner(System.in);
	String tmpname="";
	System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분,5자 이하)");
	tmpname=sc.nextLine();
	sc.close();
	return tmpname;
    }
    
    public String inputCount() {
	Scanner sc = new Scanner(System.in);
	String count;
	System.out.println("시도할 횟수는 몇회인가요?");
	count=sc.next();
	sc.close();
	return count;
    }
    
}