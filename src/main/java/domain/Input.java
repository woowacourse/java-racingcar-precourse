package domain;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Input {
	private static Scanner scanner = new Scanner(System.in);
	
	public static List<String> enterCarNames() {
		String carNames;
		String[] dividedCarNames;
		
		do{
			carNames = scanner.nextLine();
			dividedCarNames = divideNames(carNames);
		} while(!isValidDivision(dividedCarNames));
		
		return convertArrToList(dividedCarNames);
	}
	
	public static String[] divideNames(String inputString) {
		String[] temp;
		
		temp = inputString.split(",");
		
		return temp;
	}
	
	private static boolean isValidDivision(String[] inputString) {
		
		return true;
	}
	
	private static List<String> convertArrToList(String[] inputString) {
		ArrayList<String> temp = new ArrayList<String>();
		
		return temp;
	}
}
