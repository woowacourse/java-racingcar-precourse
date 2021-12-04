package racingcar;

import java.util.List;

public class GameController {
    private View view;
    private Model model;
    private List <Car> participants;
    
    public GameController(View view, Model model) {
        this.view = view;
        this.model = model;
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
}
