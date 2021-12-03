package racingcar;

import java.util.jar.Attributes.Name;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;


public class Application {

	
    public static void main(String[] args) {
    	//
    	
		String[] carNameArray = Input.carNames();
		
		
    	//System.out.println(carNameArray.length); 길이 체크

		int tryNumber = Input.tryCount();	
   
    	Car[] carArray = new Car[carNameArray.length]; 
    	
    	for(int i=0; i<carNameArray.length; i ++) {
    		carArray[i] = new Car(carNameArray[i]);
    	}
    	
    	
    	// 실행결과
    	for(int i=0; i<tryNumber; i++) {
    		for(int j=0; j<carArray.length;j++) {
    			int rand = carArray[j].randomNumber();
    			carArray[j].positionMove(rand);
    			carArray[j].visual();
    		}System.out.println();
    	}
    	
    	//최종 우승자
    	ArrayList<String> winers = finalWiner(carArray);
    	System.out.print("최종 우승자 :");
    	for(int index=0; index <winers.size(); index++) {
    		System.out.println(winers.get(index));	
    	}
    }
		
    
    
    
    public static ArrayList<String> finalWiner(Car[] arr) {
    	ArrayList<String> winers= new ArrayList<String>();
    	int mx = 0;
    	
    	for(int i =0; i< arr.length; i++) {
    		int p = arr[i].getPosition();
    		
    		if(p == mx){winers.add(arr[i].getName());}
    		
    		if(p> mx) {
    			mx = p;
    			winers.clear();
    			winers.add(arr[i].getName());
    		}
    	}
    	
		return winers;
    	
    }
    
    	
}

  

