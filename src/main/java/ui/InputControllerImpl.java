/*
 * @(#)InputControllerImpl.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package ui;

import java.util.Scanner;

public class InputControllerImpl implements InputController {

    private Scanner scanner;

    public InputControllerImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
