package inpututils;

import java.util.Scanner;

public class InputName extends Input {
	private boolean CHECKEDERROR = false;
	public InputName(Scanner scanner) {
		super(scanner);
	}

	@Override
	Scanner getScanner() {
		return super.scanner;
	}

	public String[] inputName() {
		String[] name = new String[0];
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			
			try {
				name = splitName(getScanner().next());
			}catch(IllegalArgumentException i){
				System.out.println(i.getMessage());
			}
		}while(CHECKEDERROR == false);
		return name;
	}

	private String[] checkName(String[] name){
		for(String playerName : name) {
			checkLength(playerName);
		}
		CHECKEDERROR = true;
		return name;
	}

	private void checkLength(String playerName){
		if(playerName.length() > 5){
			throw new IllegalArgumentException("잘못된 길이");
		}
	}

	public String[] splitName(String name) {
		return checkName(name.split(","));
	}
}
