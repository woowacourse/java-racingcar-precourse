package racingcar;

import java.util.ArrayList;

public class OutputView {
	InputView inputView = new InputView();
	Cars cars = new Cars();
	
	public void Racing(){
		String[] carsNames =inputView.inputCarNames();
		cars.arrayOfObjects(carsNames);
	}
}
