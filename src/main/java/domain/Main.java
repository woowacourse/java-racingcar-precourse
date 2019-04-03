/*
 * Main Class
 *
 * @version 1.1
 *
 * @date 2019-04-02
 *
 * Copyright (c) 2019. Jihun oh
 * All rights reserved
 */

package domain;

public class Main {
    public static void main(String args[]) {
        UserInterfaceImpl userInterface = new UserInterfaceImpl();
        ValidInterfaceImpl validInterface = new ValidInterfaceImpl();

        Game game = new Game(userInterface, validInterface);
        game.run();
    }
}
