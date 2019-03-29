package project;

import java.util.Scanner;

public class PlayGame {
    
    
    private String initCarName;
    private String carName[];
    private int carCount;
    void run()
    {
        inputName();
        
    }
    
    
    void inputName()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = scan.nextLine();
    }
    
    void splitName()
    {
        carName=initCarName.split(",");
        carCount=carName.length;
    }
}
