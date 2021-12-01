package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class CarListMaker {
	ArrayList<Car> carList = new ArrayList<>();

	CarListMaker(){
		makeList();
	}

	void makeList(){
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		String carListStr = Console.readLine();

		String[] carListArr = carListStr.split(",");

		for (String carName : carListArr){
			// 검사 : 1.길이제한, 2.공백존재 3.중복
			carList.add(new Car(carName));
		}
	}

	ArrayList<Car> getCarList(){
		return this.carList;
	}
}
