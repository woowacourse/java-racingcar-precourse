package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.car.Car;

class RacingWinnersViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private final String car1Name = "pobi";
    private final String car2Name = "jun";
    private List<Car> winners;

    private RacingWinnersView racingWinnersView;


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        winners = new ArrayList<>();
    }

    @Test
    void 승자가_한_명일_때_한_명의_이름만_출력_한다() {
        String expectedNotice = "최종 우승자 : pobi";
        Car car = Car.create(car1Name);
        winners.add(car);

        racingWinnersView = new RacingWinnersView(winners);
        racingWinnersView.print();

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedNotice);
    }

    @Test
    void 승자가_여러_명일_때_콤마로_구분해서_출력한다() {
        String expectedNotice = "최종 우승자 : pobi, jun";
        Car car = Car.create(car1Name);
        winners.add(car);
        Car car2 = Car.create(car2Name);
        winners.add(car2);

        racingWinnersView = new RacingWinnersView(winners);
        racingWinnersView.print();

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedNotice);
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}
