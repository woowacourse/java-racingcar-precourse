/*
 * @(#)RacingPrinter.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package util;

import java.util.List;

import domain.Raceable;

public interface RacingPrinter {
    void printStartGameSign();

    void printStateOfRacingCar(Raceable raceable);

    void printWinners(List<Raceable> winners);

    void printOneCycleFinished();

    void printRequestForNames();

    void printRequestForCycles();

    void printErrorWhenExtractingNames(RuntimeException e);

    void printErrorWithTooSmallCycle(int minCycles);

    void printErrorWithNotNaturalNumber();

    void printErrorGameFinishedAbnormal(String message);
}
