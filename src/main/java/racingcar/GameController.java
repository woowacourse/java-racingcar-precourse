package racingcar;

import java.util.List;

public class GameController {
    private View view;
    private Model model;
    private List <Car> participants;
    private int goal;
    
    public GameController(View view, Model model) {
        this.view = view;
        this.model = model;
    }
    
    public void playGame() {
        setParticipants();
        setGoal();
        System.out.println(view.RESULT_MESSAGE);
          
        while(!model.hasWinner(participants, goal)) {
           model.setPositions(participants);
           view.showRaceMessage(participants);
        }
        
        view.showWinnerMessage(model.getWinner(participants, goal));
    }
    
    private void setParticipants() {
        String input = view.nameOfCars();
        
        if(model.checkValidationForCars(input)) {
            participants = model.getCarNames(input);
            return;
        }
        
        System.out.println(view.ERROR_MESSAGE_CAR);
        setParticipants();
    }
    
    private void setGoal() {
        String input = view.getGoal();
        
        if(model.checkValidationForGoal(input)) {
            goal = Integer.parseInt(input);
            return;
        }
        
        System.out.println(view.ERROR_MESSAGE_GOAL);
        setGoal();
    }
    
}
