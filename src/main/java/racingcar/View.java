package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {
    
    public View () {}
    
    public String nameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        
        return Console.readLine();
    }
    
    public String numOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        
        return Console.readLine();
    }
    
    public String showRaceMessage(String [] cars, int [] positions) {
        String result = "실행 결과\n";
        
        for(int i = 0; i < cars.length; i++) {
            result += showPosition(cars[i], positions[i]) + "\n";
        }
        
        return result;
    }
    
    public String showErrorMessage() {
        return "[ERROR] 시도 횟수는 숫자여야 한다.";
    }
    
    private String showPosition(String car, int position) {
        String result = car + " : ";
        
        while(position-- > 0) {
            result += "-";
        }
        
        return result;
    }
}
