package view;

import static view.OutputView.*;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
	private static Scanner scanner;

	public InputView(InputStream inputStream) {
		scanner = new Scanner(inputStream);
	}

	public String getNames() {
		showCarNamesInfo();
		return scanner.nextLine();
	}

	public int getTryCount() {
		showTryCountInfo();
		return scanner.nextInt();
	}

}
