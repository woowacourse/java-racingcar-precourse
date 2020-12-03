package racingcar;

import controller.CarController;
import org.junit.jupiter.api.Test;
import preprocess.InputPreProcess;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    @Test
    void getNames() {

        InputPreProcess input = new InputPreProcess();
        CarController controller = new CarController();

        GameBoard board = new GameBoard(input, controller);


        // 5글자 이상일 때
        assertFalse(board.getNames("이름,dlfmadddd,name"));

        // 중복이 있을 때
        assertFalse(board.getNames("이름,이름,name"));

        // 특수 기호 잘못 썼을 때
        assertFalse(board.getNames("name,name.이름"));
        
        // 정상
        assertTrue(board.getNames("name,이름,na이름"));
    }

    @Test
    void startRace() {

        InputPreProcess input = new InputPreProcess();
        CarController controller = new CarController();

        GameBoard board = new GameBoard(input, controller);

        board.getNames("name,namea,vnds,dveir");

        // lap이 엄청 클 때
        String lap = "1000000000000000000000000000000000000000";
        assertFalse(board.startRace(lap));

        // lap이 숫자 말고 다른 것이 포함되어 있을 때
        lap = "1242d0fg8";
        assertFalse(board.startRace(lap));

        // lap이 음수일 때
        lap = "-204";
        assertFalse(board.startRace(lap));

        // 정상일 때
        lap = "10";
        assertTrue(board.startRace(lap));
    }
}