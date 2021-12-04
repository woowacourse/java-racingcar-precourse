package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public static final String ERROR_MESSAGE_CAR = "[ERROR] 입력이 형식에 맞지 않습니다.";
    public static final String ERROR_MESSAGE_GOAL = "[ERROR] 시도 횟수는 숫자여야 한다.";
    public static final String RESULT_MESSAGE = "실행 결과";
    
    public View () {}
    
    public String nameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        
        return Console.readLine();
    }
    
    public String getGoal() {
        System.out.println("시도할 회수는 몇회인가요?");
        
        return Console.readLine();
    }
    
    public void showRaceMessage(List<Car> participants) {
        
        participants.stream().forEach(c -> System.out.println(showPosition(c)));
        System.out.println();
        
    }
    
    public void showWinnerMessage(List<Car> winners) {
        String result = "최종 우승자 : ";
        
        for(int i = 0; i < winners.size(); i++) {
            result += winners.get(i).getName();
            if(i < winners.size()-1) {
                result += ", ";
            }
        }
        
        System.out.println(result);
    }
    
    private String showPosition(Car participant) {
        String result = participant.getName() + " : ";
        int position = participant.getPosition();
        
        while(position-- > 0) {
            result += "-";
        }
        
        return result;
    }
}
