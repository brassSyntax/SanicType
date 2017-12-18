import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class RaceTextReaderTest {
    @Test
    public void readFile1() throws Exception {
        String text = "Let me get this straight. You think that your client, one of the wealthiest, most powerful " +
                "men in the world, is secretly a vigilante who spends his nights beating criminals to a pulp with " +
                "his bare hands? And your plan is to blackmail this person?";

        assertEquals(RaceTextReader.readFile("TheDarkKnight.txt"),text);
    }

    @Test
    public void readFile2() throws Exception {
        String text = "Foo bar.";

        assertEquals(RaceTextReader.readFile("debug.txt"), text);
    }

    @Test
    public void readFile3() throws Exception {
        File file = new File("TheDarkKnight.txt");
        String text = "Let me get this straight. You think that your client, one of the wealthiest, most powerful " +
                "men in the world, is secretly a vigilante who spends his nights beating criminals to a pulp with " +
                "his bare hands? And your plan is to blackmail this person?";

        assertEquals(RaceTextReader.readFile(file),text);
    }

    @Test
    public void readFile4() throws Exception {
        File file = new File("debug.txt");
        String text = "Foo bar.";

        assertEquals(RaceTextReader.readFile(file), text);
    }
}