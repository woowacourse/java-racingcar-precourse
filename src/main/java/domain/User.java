package domain;

import java.util.Scanner;

public class User {
	
	public String[] EnterCarName() {
		String[] CarNameArray;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("경주할 자동차 이름을 5자 이하로 입력하세요. (이름은 쉼표(,) 기준으로 구분) : ");
			String CarNameString = scanner.nextLine();
			CarNameArray = CarNameString.split(",");
			
			for (int i=0; i<CarNameArray.length; i++) {
				String name = CarNameArray[i];
				CarNameArray[i] = name.trim();
			}
			
			int error_or_not = Exception(CarNameArray);
			if (error_or_not == 0) {
				break;
			}
			System.out.println("자동차 이름을 1자 이상 5자 이하로 입력해주세요.");
			scanner.reset();
			
		}
		return CarNameArray;
	}
	
	public int Exception(String[] arr) {
		int error = 0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i].length() > 5 || arr[i].length() == 0) {
				error += 1;
				break;
			}
		}
		return error;
	}
}
