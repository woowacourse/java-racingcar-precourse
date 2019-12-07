package domain;

import java.util.ArrayList;
import java.util.Scanner;


public class User {
    private int count = 0;
    
    public String inputCar() {
	Scanner sc = new Scanner(System.in);
	String tmpname="";
	System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분,5자 이하)");
	tmpname=sc.nextLine();
	return tmpname;
    }
    
}