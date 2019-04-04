package logic;

import domain.Track;
import ui.ConsoleIOInterface;
import ui.RaceIOInterface;

import java.util.Objects;

/**
 * domain과 ui객체를 이용한 실직적인 로직을 구현한 클래스
 *
 * @author delf
 */
public class RaceSimulator {
    private RaceIOInterface raceIOInterface;
    private Track track;

    public RaceSimulator with(RaceIOInterface raceIOInterface) {
        this.raceIOInterface = raceIOInterface;
        return this;
    }

    public void run(String[] racer, int nRaceSimulTry) throws IllegalArgumentException {
        checkIOInterfaceAssertion();

        track = new Track(racer);
        raceStart(nRaceSimulTry);

        raceIOInterface.showWinner(track);
    }

    /* 입출력 클래스가 없으면, 예외를 발생시킨다. */
    private void checkIOInterfaceAssertion() {
        if (Objects.nonNull(raceIOInterface)) {
            /* 본 미션에는 벌다른 구현체가 없기 때문에 예외를 던지는 것이 아니라, 기본 구현체를 할당해준다. */
            raceIOInterface = new ConsoleIOInterface();
        }
    }

    /* 사용자 입력을 받아 경주를 실행한다. */
    public void run() {
        String[] racer = raceIOInterface.inputRacersName();
        int nRaceSimulTry = raceIOInterface.inputTryCount();

        run(racer, nRaceSimulTry);
    }

    /* 실제 입력받은 횟수만큼 경주를 진행하고 각 시도에 따른 결과를 출력한다. */
    private void raceStart(int nRaceSimulTry) {
        RaceIOInterface.showPlaneText("\n실행 결과");

        for (int i = 0; i < nRaceSimulTry; i++) {
            track.next();
            raceIOInterface.showTrack(track);
        }
    }
}