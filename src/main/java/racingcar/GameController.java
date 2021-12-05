package racingcar;

import java.util.List;

import model.*;
import view.*;

public class GameController {
    private static final String TYPE1 = "Car";
    private static final String TYPE2 = "Num";
    
    private GameEquipments equipments;
    private Input input;
    private InputValidation inputValidation;
    private Output output;
    private Winner winner;
    
    protected List<Car> participants;
    protected int goal;
    
    public GameController() {
        equipments = new GameEquipments();
        input = new Input();
        inputValidation = new InputValidation();
        output = new Output();
        winner = new Winner();
    }
    
    public void playGame() {
        saveParticipants();
        saveGoal();
        System.out.println(Output.RESULT_MESSAGE);
        
        while(!winner.hasWinner(participants, goal)) {
           equipments.setPositions(participants);
           output.showRaceMessage(participants);
        }
        
        output.showWinnerMessage(winner.getWinner(participants, goal));
    }
    
    private void saveParticipants() {
        while(true) {
            String str = input.setCarNames(); 
            
            try {
                inputValidation.checkValidationForCars(str);
                participants = equipments.toList(str);
                return;
            } catch (IllegalArgumentException e) {
                output.showErrorMessage(TYPE1);
            }
        }
    }
    
    private void saveGoal() {
        while(true) {
            String num = input.setGoal();
          
            try {
                inputValidation.checkValidationForGoal(num);
                goal = Integer.parseInt(num);
                return;
            } catch (IllegalArgumentException e) {
                output.showErrorMessage(TYPE2);
            }
        }
    }
}
