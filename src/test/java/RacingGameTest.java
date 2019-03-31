import domain.RacingGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RacingGameTest {
    private RacingGame racingGame;

    @Before
    public void setUp() throws Exception{
        racingGame = new RacingGame();
    }

    @Test
    public void testSplit() throws Exception{
        String[] result = racingGame.inputCarName("abc,def,xyz");
        Assert.assertArrayEquals(new String[]{"abc","def","xyz"},result);
    }
    @Test
    public void testSplitNull() {
        String[] result = racingGame.inputCarName(null);
        Assert.assertArrayEquals(new String[]{},result);
    }
    @Test
    public void testSplitOneString() {
        String[] result = racingGame.inputCarName("abc");
        Assert.assertArrayEquals(new String[]{"abc"}, result);
    }

    @Test
    public void testGetCarNameCountMultiple() {
        String[] result = racingGame.inputCarName("abc,deb,xyz");
        Assert.assertEquals(3
                ,result.length);
    }
    @Test
    public void testGetCarNameCountOne() {
        String[] result = racingGame.inputCarName("abc");
        Assert.assertEquals(1,result.length);
    }
    @Test
    public void testGetCarNameCountNull() {
        String[] result = racingGame.inputCarName(null);
        Assert.assertEquals(0,result.length);
    }

    @Test
    public void testCorrectuserInput() {
        boolean result = racingGame.isCorrectInput(new String[]{"abc","dev","123"});
        Assert.assertEquals(true,result);
    }
    @Test
    public void testCorrectuserInput2() {
        boolean result = racingGame.isCorrectInput(new String[]{"abc","dev","123456"});
        Assert.assertEquals(false,result);
    }
    @Test
    public void testCorrectuserInputNull() {
        boolean result = racingGame.isCorrectInput(new String[]{""});
        Assert.assertEquals(false,result);
    }
}