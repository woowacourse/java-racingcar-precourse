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
        String str = input.setCarNames(); 
            
        try {
            
            if(!inputValidation.checkValidationForCars(str)) {
                throw new IllegalArgumentException();
            }
                
            participants = equipments.toList(str);
            return;
        } catch (IllegalArgumentException e) {
            output.showErrorMessage(TYPE1);
            saveParticipants();
        }
    }
    
    private void saveGoal() {
        String num = input.setGoal();
            
        try {
            
            if(!inputValidation.checkValidationForGoal(num)) {
                throw new IllegalArgumentException();
            }
            
            goal = Integer.parseInt(num);
            return;
        } catch (IllegalArgumentException e) {
            output.showErrorMessage(TYPE2);
            saveGoal();
        }
    }
}
