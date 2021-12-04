package racingcar;

import java.util.List;

public class GameController {
    private static final String TYPE1 = "Car";
    private static final String TYPE2 = "Num";
    private View view;
    private Model model;
    protected List <Car> participants;
    protected int goal;
    
    public GameController(View view, Model model) {
        this.view = view;
        this.model = model;
    }
    
    public void playGame() {
        setParticipants();
        setGoal();
        System.out.println(View.RESULT_MESSAGE);
        
        while(!model.hasWinner(participants, goal)) {
           model.setPositions(participants);
           view.showRaceMessage(participants);
        }
        
        view.showWinnerMessage(model.getWinner(participants, goal));
    }
    
    private void setParticipants() {
        while(true) {
            String input = view.nameOfCars(); 
            
            try {
                if(!model.checkValidationForCars(input)) {
                    throw new IllegalArgumentException();
                }
                participants = model.getCarNames(input);
                return;
            }
            catch (IllegalArgumentException e) {
                view.showErrorMessage(TYPE1);
            }
        }
    }
    
    private void setGoal() {
        while(true) {
            String input = view.getGoal();
            
            try {
                if(!model.checkValidationForGoal(input)) {
                    throw new IllegalArgumentException();
                }
                goal = Integer.parseInt(input);
                return;
            }
            catch (IllegalArgumentException e) {
                view.showErrorMessage(TYPE2);
            }
        }
    }
}
