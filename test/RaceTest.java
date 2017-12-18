import org.junit.Test;

import static org.junit.Assert.*;

public class RaceTest {
    @Test
    public void next1() throws Exception {
        Race race = new Race("asdfg");

        assertFalse(race.next("asd"));
    }

    @Test
    public void next2() throws Exception {
        Race race = new Race("");

        assertTrue(race.next(""));
    }

    @Test
    public void next3() throws Exception {
        Race race = new Race("asdfg");

        assertTrue(race.next("asdfg"));
    }

    @Test
    public void next4() throws Exception {
        Race race = new Race("asdfg ");

        assertTrue(race.next("asdfg "));
    }
}