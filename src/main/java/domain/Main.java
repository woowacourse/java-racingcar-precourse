package domain;

import java.util.Arrays;
import java.util.List;

import domain.utils.InputUtils;
import domain.utils.OutputUtils;

public class Main {
	public static void main(String[] args) {
		List<String> carNames=InputUtils.inputNames();
		Integer numberToRun=InputUtils.inputRuns();
		List<Car> carsList=makeCarsList(carNames);

		System.out.println("실행 결과");
		for(int i=0;i<numberToRun;i++){
			runCars(carsList);
			carsList.stream().forEach(OutputUtils::printCarProgress);
		}

		List<String>winners=;
		OutputUtils.printWinner();
		InputUtils.inputClose();
	}
}
