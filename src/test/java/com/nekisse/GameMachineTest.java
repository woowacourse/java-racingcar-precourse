package com.nekisse;

import com.nekisse.domain.CarName;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameMachineTest {

    private List<CarName> names;

    @Test
    public void 자동차_이름_3개_생성() {
        names = new ArrayList<>();
        names.addAll(Arrays.asList(CarName.newCarName("aa"),CarName.newCarName("bb"),CarName.newCarName("cc")));
        GameMachine gameMachine = new GameMachine(1, names);
        assertThat(gameMachine.getCars().size()).isEqualTo(3);

    }


}