package domain;

import java.util.Scanner;

public class gameMc {
    private String[] userInput;
    private int round = 0;


    public String Input(){
        Scanner input = new Scanner(System.in);
        return input.next();
    }
    public boolean isOverFiveWords(String[] userInput){
        for(int i=0;i<userInput.length;i++){
            if(userInput[i].length() > 5){
                return true;
            }
        }
        return false;
    }
    public void gameStart(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        userInput = Input().split(",");
        while(isOverFiveWords(userInput)){
            System.out.println("자동차 이름은 5글자 이하만 가능합니다. 다시 입력하세요.");
            userInput = Input().split(",");
        }
        System.out.println("시도할 회수는 몇회인가요.");
        while(round == 0){
            try{
                round = Integer.parseInt(Input());
                if(round==0){
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e){
                System.out.println("0 이상의 숫자만 입력해주세요.");
            }
        }
    }
}
