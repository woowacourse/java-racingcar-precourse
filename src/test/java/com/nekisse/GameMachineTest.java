package com.nekisse;

import com.nekisse.domain.CarName;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameMachineTest {

    private List<CarName> carNames = new ArrayList<>();

    private List<CarName> getTwoCar() {
        return Arrays.asList(CarName.newCarName("aa"), CarName.newCarName("bb"));
    }

    @Test
    public void 자동차_이름_2개_생성() {
        carNames.addAll(getTwoCar());
        GameMachine gameMachine = new GameMachine(1, carNames, null);
        assertThat(gameMachine.getCars().size()).isEqualTo(2);
    }

    @Test
    public void 이동가능한_랜덤값_생성시_이동_가능() {
        carNames.addAll(getTwoCar());
        GameMachine gameMachine = new GameMachine(3, carNames, new RandomNumberGenerator() {
            @Override
            public int generateRandomNumber() {
                return 4;
            }
        });
        gameMachine.runCar();
        gameMachine.runCar();
        assertThat(gameMachine.getCars().get(0).getPosition()).isEqualTo(2);
        assertThat(gameMachine.getCars().get(1).getPosition()).isEqualTo(2);
    }

    @Test
    public void 이동불가능한_랜덤값_생성시_이동_하지_않음() {
        carNames.addAll(getTwoCar());
        GameMachine gameMachine = new GameMachine(3, carNames, new RandomNumberGenerator() {
            @Override
            public int generateRandomNumber() {
                return 3;
            }
        });
        gameMachine.runCar();
        gameMachine.runCar();
        assertThat(gameMachine.getCars().get(0).getPosition()).isEqualTo(0);
        assertThat(gameMachine.getCars().get(1).getPosition()).isEqualTo(0);
    }




}