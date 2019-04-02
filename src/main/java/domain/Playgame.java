/*
 * @(#)Playgame.java	1.8.0_191 2019/04/02
 * 
 * Copyright (c) 2019 Youngbae Son
 * ComputerScience, ProgrammingLanguage, Java, Busan, KOREA
 * All rights reserved.
 * 
 * */

package domain;

/*
 * 게임시작
 * 게임운영 module을 사용하는 클래스
 * 
 * @author 손영배
 * */

public class Playgame {

	public static void main(String[] args) {

		Gamemodule module = new Gamemodule();

		module.initSetup();

		for (int i = 0; i < module.getInputRound(); i++) {
			module.racing();
		}

		module.checkWinner();

	}
}
