/*
 * UserInterfaceimpl Class
 *
 * @version 2
 *
 * @date 2019-04-02
 *
 * Copyright (c) 2019. Jihun oh
 * All rights reserved
 */

package domain;

import domain.interfaces.UserInterface;

import java.util.List;
import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {

    Scanner scanner;
    boolean wasCalledPrintGameState;

    public UserInterfaceImpl() {
        this.scanner = new Scanner(System.in);
        this.wasCalledPrintGameState = false;
    }

    @Override
    public String[] inputCarName() {
        String[] carNames;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = scanner.nextLine().split(",");
        return carNames;
    }

    @Override
    public String inputGameCount() {
        String gameRepeatCounts;

        System.out.println("시도할 회수는 몇회인가요?");
        gameRepeatCounts = scanner.nextLine();
        return gameRepeatCounts;
    }

    @Override
    public void alertInvalidCarCount() {
        System.out.println("자동차의 갯수가 0개 입니다.\n");
    }

    @Override
    public void alertInvalidCarNameLength() {
        System.out.println("5자 이하의 이름을 입력하세요.\n");
    }

    @Override
    public void alertCarNameDuplicate() {
        System.out.println("자동차 이름이 중복되었습니다.\n");
    }

    @Override
    public void alertInvalidGameCount() {
        System.out.println("게임의 횟수는 양수입니다.\n");
    }

    @Override
    public void printGameState(List<Car> carList) {
        if (!wasCalledPrintGameState) {
            System.out.println("실행결과");
            wasCalledPrintGameState = true;
        }

        StringBuilder gameState = new StringBuilder();
        for (Car car : carList) {
            gameState.append(car.getName()).append(":");
            for (int distance = 0; distance < car.getPosition(); distance++)
                gameState.append("-");
            gameState.append("\n");
        }

        System.out.println(gameState);
    }

    @Override
    public void printWinner(List<Car> carList) {
        StringBuilder winnerInfo = new StringBuilder();

        winnerInfo.append(carList.get(0).getName());
        for (int th = 1; th < carList.size(); th++) {
            winnerInfo.append(",");
            winnerInfo.append(carList.get(th).getName());
        }
        winnerInfo.append("가 최종 우승했습니다.");

        System.out.println(winnerInfo);
    }
}
