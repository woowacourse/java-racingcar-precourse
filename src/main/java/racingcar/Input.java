package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	

	public static String[] carNames() {
		String[] CarNameArray;
		while(true) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	    	String Carstirng = Console.readLine();
	    	CarNameArray = StringToArray(Carstirng);
	    	if(exception(CarNameArray))
	    	{
	    		break;
	    	}
	    	
		}
    	return CarNameArray;
	}


	
	public static String[] StringToArray(String str) {
		String[] nameArray = str.split(",");
		
		for (int i=0; i<nameArray.length; i++) {
			String name = nameArray[i];
			nameArray[i] = name.trim();
		} 
		return nameArray;
	}
	
	public static boolean exception(String[] arr) {
		for (int i=0; i<arr.length; i++) {
			if (arr[i].length() > 5 || arr[i].length() == 0) {
				IllegalArgumentException errorMessage = new IllegalArgumentException("[ERROR] 자동차이름은 5자 이하여야한다.");
		    	System.out.println(errorMessage); 
				return false;
			}
		}
		return true;
	}
	
	
	
	
	public static int tryCount(){
		int tryNumberInt;
		String tryNumberString;
		//boolean check = true;
		
		while(true) { // check로 넣으면 왜 반환이 에러가 뜰까?
			System.out.println("시도할 회수는 몇회인가요?");
			tryNumberString = Console.readLine();
	    	
	    	if(numberCheck(tryNumberString)) {
	    		tryNumberInt = Integer.parseInt(tryNumberString);
	    		break;
	    	}
	    	//잘못된 입력 에러 메시지 출력
	    	IllegalArgumentException errorMessage = new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
	    	System.out.println(errorMessage); 
		}
		return tryNumberInt;
	}
	
	

   
   private static boolean numberCheck(String str){
   	if(str.chars().allMatch(Character::isDigit)){
   		return true;
   	}
   	return false;
   
   	
   }
}
