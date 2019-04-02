package domain;

import java.util.Scanner;

public class GameMain {

	static String nameArray [];
	
	//쉼표 기준으로 이름 구분하는 메소드
	static void nameDistinguish(String names){
		nameArray = names.split(",");	//쉼표로 자동차 이름 분리해 배열로 저장
	}
	
	//이름이 5자 이하인지 확인하는 메소드
	static boolean isNameLessThan5(){
		for(int i=0; i<nameArray.length; ++i){
			if(nameArray[i].length()>5){
				System.out.println("자동차 이름은 5자 이하만 가능합니다.");
				System.out.println("경주할 자동차 이름을 입력하세요. 이름은 쉼표(,) 기준으로 구분");
				return false;
			}
		}
		return true;
	}
		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		
		do{
			String names = in.next();	//자동차 이름 입력
			nameDistinguish(names);		//쉼표 기준으로 이름 구분
		}while( !isNameLessThan5() );	//이름이 5자 이하일 때 까지 반복

	}

}
