package logic;

import domain.Track;
import ui.ConsolIOInterface;
import ui.RaceIOInterface;

import java.util.Objects;

/**
 * @author delf
 */
public class RaceSimulator {
    private RaceIOInterface raceIOInterface;
    private Track track;

    public RaceSimulator with(RaceIOInterface raceIOInterface) {
        this.raceIOInterface = raceIOInterface;
        return this;
    }

    public void run() {
        checkIOInterfaceAssertion();

        String[] racer = raceIOInterface.inputRacersName("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        int nRaceSimulTry = raceIOInterface.inputNumber("시도할 회수는 몇회인가요?");

        track = new Track(racer);
        raceStart(nRaceSimulTry);
        raceIOInterface.showWinner(track);
    }

    private void raceStart(int nRaceSimulTry) {
        for (int i = 0; i < nRaceSimulTry; i++) {
            track.initTrack();
            raceIOInterface.showTrack(track);
        }
    }

    private void checkIOInterfaceAssertion() {
        if (Objects.nonNull(raceIOInterface)) {
            /* 벌다른 구현체가 없기 때문에 예외를 던지는 것이 아니라, 기본 구현체를 할당해준다. */
            raceIOInterface = new ConsolIOInterface();
        }
    }


}
