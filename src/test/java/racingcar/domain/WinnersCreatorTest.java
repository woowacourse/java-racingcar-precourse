package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WinnersCreatorTest {
    private Car myCar = mock(Car.class);
    private Car woniCar = mock(Car.class);
    private Car fobiCar = mock(Car.class);
    private RacingGame racingGame = mock(RacingGame.class);

    @BeforeAll
    public void setUp() {
        when(myCar.getName()).thenReturn("heon");
        when(woniCar.getName()).thenReturn("woni");
        when(fobiCar.getName()).thenReturn("fobi");

        when(myCar.isWinner(anyInt())).thenCallRealMethod();
        when(woniCar.isWinner(anyInt())).thenCallRealMethod();
        when(fobiCar.isWinner(anyInt())).thenCallRealMethod();

        when(racingGame.getCars()).thenReturn(Arrays.asList(myCar, woniCar, fobiCar));
    }

    @Test
    public void WinnerCreator_동작_확인_나만_단독_우승일_때() {
        //given
        when(myCar.getPosition()).thenReturn(2);
        when(woniCar.getPosition()).thenReturn(0);
        when(fobiCar.getPosition()).thenReturn(0);

        //when
        Winners winners = WinnersCreator.createWinners(racingGame);

        //then
        assertThat(winners.getWinners()).containsOnly("heon");
    }

    @Test
    public void WinnerCreator_동작_확인_두명_공동_우승일_때() {
        //given
        when(myCar.getPosition()).thenReturn(2);
        when(woniCar.getPosition()).thenReturn(2);
        when(fobiCar.getPosition()).thenReturn(0);

        //when
        Winners winners = WinnersCreator.createWinners(racingGame);

        //then
        assertThat(winners.getWinners()).containsOnly("heon", "woni");
    }

    @Test
    public void WinnerCreator_동작_확인_모두_공동_우승일_때() {
        //given
        when(myCar.getPosition()).thenReturn(2);
        when(woniCar.getPosition()).thenReturn(2);
        when(fobiCar.getPosition()).thenReturn(2);

        //when
        Winners winners = WinnersCreator.createWinners(racingGame);

        //then
        assertThat(winners.getWinners()).containsOnly("heon", "woni", "fobi");
    }
}