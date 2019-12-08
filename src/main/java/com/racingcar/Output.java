package com.racingcar;

import java.util.Iterator;
import java.util.List;

/**
 * Output
 *
 * @author hyochan
 * @version 0.0.1
 * @since 2019-12-07
 */

public class Output {
    public void printWinner(List<String> winner) {
        System.out.println();
        Iterator itr = winner.iterator();
        while (itr.hasNext()) {
            System.out.print((String) itr.next());
            if (itr.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public void printCarPosition(Car car) {
        int position = car.getPosition();
        System.out.print("\n" + car.getName() + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}
