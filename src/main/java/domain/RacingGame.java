/*
 * @(#)RacingGame.java        2019/12/10
 *
 *
 */

package domain;

/**
 * 자동차 경주 게임의 작동을 위한 RacingGame 클래스
 *
 * @version		0.1 2019년 12월 10일
 * @author		YerinCho          
 */

import java.util.ArrayList;

public class RacingGame {
    private static final String RESULT_MESSAGE ="실행 결과";
    private static final String COMMA=",";
    private static final int DELAY_SECOND=1000;
    private static final int ERROR_COUNT_INPUT=-1;
    private int count;
    private Car[] car;
    
    User user = new User();
    UserInputChecking userinputcheck= new UserInputChecking();
    Computer computer = new Computer();
    Message message = new Message();
    
    public void run() {
	enterCarInfo();
	System.out.println(RESULT_MESSAGE);
	
	/*시도횟수만큼 실행*/
	for(int i=0;i<this.count;i++) {
	    createAndSetPosition();
	    showResult();	
	    sleep();		//딜레이
	}
	showWinner();		
    }
    
    /*자동차의 이름과, 시행횟수 입력*/
    public void enterCarInfo() {
	enterName();
	enterCount();
    }
    
    /*랜덤 수 생성하고, position의 값 변경*/
    public void createAndSetPosition() {
	for(int i=0;i<car.length;i++) {
	    car[i].isGoStop(computer.createRandNum());
	}
    }
    
    public void showResult() {
	for(int i=0;i<car.length;i++) {
	    message.playResult(car[i].getName(), car[i].getPosition());
	}
	System.out.println();
    }
    
    
    /*한 번의 횟수 시행 후 긴장감을 위해 딜레이*/
    public void sleep() {
	try {
	    Thread.sleep(DELAY_SECOND); 		//1초 대기
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
    
    public void showWinner() {
	boolean found=false;
	
	/*
	 * 최대로 가능한 position 값인 count부터 시작하여
	 * 그 값과 같은 position인 자동차가 나타날 경우 반복문을 탈출한다.
	 * */
	for(int i=this.count;i>=0;i--) {
	    found=findPosition(i);
	    if(found) {
		break;
	    }
	}
    }
    
    
    public boolean findPosition(int c){
	boolean f=false;
	ArrayList<String> winner=new ArrayList<>();	//우승자를 저장할 변수
	for(int i=0;i<car.length;i++) {		
	    
	    /*position값과 같은경우 우승자에 추가하고, 반복문 탈출을 위해 f=true 설정*/
	    if(c==car[i].getPosition()) {
		f=true;
		winner.add(car[i].getName());
	    }
	}
	if(f) {
	    message.judgeWinner(winner);
	}
	return f;
    }
    
    public void enterName() {
	String carname=user.inputCar();
	
	/*자동차이름 입력이 올바르게 될때까지 반복*/
	while(userinputcheck.checkCarName(carname)==false) {
	    carname=user.inputCar();
	}
	String[] tmpname = carname.split(COMMA);
	car=new Car[tmpname.length];
	for(int i=0;i<tmpname.length;i++) {
	    this.car[i]=new Car(tmpname[i]);
	}
    }
    
    public void enterCount() {
	int tmpcount=userinputcheck.checkCount(user.inputCount());
	
	/*횟수입력이 올바르게 될때까지 반복*/
	while(tmpcount==ERROR_COUNT_INPUT) {
	    tmpcount=userinputcheck.checkCount(user.inputCount());
	}
	
	this.count=tmpcount;
    }
}


