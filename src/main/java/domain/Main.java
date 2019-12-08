package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import domain.utils.InputUtils;
import domain.utils.OutputUtils;

public class Main {
	public static void main(String[] args) {
		List<String> carNames=InputUtils.inputNames();
		Integer numberToRun=InputUtils.inputRuns();
		List<Car> carList=makeCarsList(carNames);


		System.out.println("실행 결과");
		for(int i=0;i<numberToRun;i++){
			runCars(carList);
			carList.stream().forEach(OutputUtils::printCarProgress);
			System.out.println();
		}

		List<String>winners=findWinners(carList);
		OutputUtils.printWinner(winners);
		InputUtils.inputClose();
	}
	static List<Car> makeCarsList(List<String>carNames){
		List<Car> carList=new ArrayList<Car>();
		for (String name:carNames
			 ) {
			carList.add(new Car(name));
		}
		return carList;
	}

	static void runCars(List<Car> carList){
		Random random=new Random();
		for (Car car:carList
		) {
			car.run(random.nextInt(10));
		}
	}
}
