package racingcar.processor;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputProcessor {

	public List<String> readNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String[] names = readLine().split(",");
		return Arrays.asList(names);
	}

	public String readCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		return readLine();
	}

	private String readLine(){
		return Console.readLine();
	}
}
