package racingcar;

import View.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racing {

    List<Car> cars = new ArrayList<>();

    public void init(Scanner scanner){
        saveCarName(scanner);
    }

    public void saveCarName(Scanner scanner){
        OutputView.writeCarName();
        
    }

}
