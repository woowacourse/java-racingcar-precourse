package project;

import java.util.Scanner;

public class PlayGame {
        
    private String initCarName;
    private String carName[];
    private int carCount;
    private int gameCount;
    private Car car[];
    
    void run() {
        inputName();
        splitName();
        inputGameCount();
        createCar();
        playGame();
        findWinner();        
    }
    
    void inputName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        initCarName = sc.nextLine();
    }
    
    void splitName() {
        carName=initCarName.split(",");
        carCount=carName.length;        
    }
    
    void inputGameCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요?");
        gameCount = sc.nextInt();
    }
    
    void createCar() {
        car = new Car[carCount];
        for(int i=0;i<carCount;i++){
            car[i]=new Car(carName[i].trim());
        }
    }
    
    void playGame() {
        for(int i=0;i<gameCount;i++) {
            playGameForMove();            
        }
    }
    void playGameForMove(){
        for(int i=0;i<carCount;i++){
            car[i].moveCar();
            car[i].printCar();
        }
        System.out.println();
    }
    
    void findWinner(){
        int _max=0;
        int carPos;
        String winnerName[]=new String[carCount];
        int winnerCnt=0;
        for(int i=0;i<carCount;i++){
            carPos=car[i].getPosition();
            if(isEqualPosition(_max, carPos)==true){
                winnerName[winnerCnt++]=car[i].getName(); 
            }
            if(isLargePosition(_max,carPos)==true){
                winnerCnt=0;
                _max=carPos;
                winnerName[winnerCnt++]=car[i].getName();                
            }            
        } 
        printWinner(winnerName, winnerCnt);
    }
    
    boolean isLargePosition(int _max, int carPos){
        return _max<carPos?true:false;        
    }
    
    boolean isEqualPosition(int _max, int carPos){
        return _max==carPos?true:false;        
    }
    
    void printWinner(String winnerName[], int winnerCnt) {
        for(int i=0;i<winnerCnt;i++){
            System.out.print(winnerName[i]);
            if(i!=winnerCnt-1){
                System.out.print(", ");
            }
        }
        System.out.print("가 최종 우승했습니다.");
    }
    
}
