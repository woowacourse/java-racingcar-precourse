package view;

import java.util.List;

import model.Car;

public class Output {
    public static final String RESULT_MESSAGE = "실행 결과";
    
    public Output() {}
    
    public void showRaceMessage(List<Car> participants) {
        
        participants.stream().forEach(c -> System.out.println(showPosition(c)));
        System.out.println();
    }
    
    public void showErrorMessage(String type) {
        if(type.equals("Car")) {
            System.out.println("[ERROR] 입력한 자동차 이름이 형식에 맞지 않습니다.");
            return;
        }
        if(type.equals("Num")) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
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
