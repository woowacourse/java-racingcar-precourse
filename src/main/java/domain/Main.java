package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	static final String REPETITION_QUESTION = "시도할 회수는 몇회인가요?";
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(CAR_NAME_QUESTION);
		
		
		
		String nameOfCars = in.readLine();
		
		String[] carNameArr = nameOfCars.split(",");
		int numOfCars = carNameArr.length;
		
		//자동차 이름이 5자 이상
		if(!checkCarNameLength(carNameArr)) {
			System.out.println("자동차 이름이 5자 초과입니다. 종료합니다.");
			return;
		}
		
		
		Car[] carArr = new Car[numOfCars];
		
		for(int i = 0; i < numOfCars; i++) {
			carArr[i] = new Car(carNameArr[i]);
		}
		
		
	}
	
	private static  boolean checkCarNameLength(String[] carNameArr) {
		for(int i = 0; i < carNameArr.length; i++) {
			if(carNameArr[i].length() > 5) {
				return false;
			}
		}
		return true;
	}
	

}
