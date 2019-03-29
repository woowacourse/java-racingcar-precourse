package project;

import java.util.Scanner;

public class PlayGame {
    
    
    private String initCarName;
    private String carName[];
    private int carCount;
    private int gameCount;
    private Car car[];
    void run()
    {
        inputName();
        splitName();
        inputGameCount();
        createCar();
        playGame();
        
    }
    
    
    void inputName()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        initCarName = sc.nextLine();
    }
    
    void splitName()
    {
        carName=initCarName.split(",");
        carCount=carName.length;
    }
    
    void inputGameCount()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요?");
        gameCount = sc.nextInt();
    }
    void createCar()
    {
        car = new Car[carCount];
        for(int i=0;i<carCount;i++){
            car[i]=new Car(carName[i]);
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
        }
    }
}
