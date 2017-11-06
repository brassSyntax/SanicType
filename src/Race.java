import java.io.FileReader;
import java.util.Scanner;

public class Race {

    private boolean finished;
    private String raceText;
    private int raceLength;
    private int racePos;

    public Race() {
        this.finished = false;
        this.raceText = null;
        this.raceLength = 0;
        this.racePos = 0;
    }

    public Race(String text) {
        this.raceText = text;
        this.raceLength = text.length();
        this.racePos = 0;
    }

    public boolean isFinished()
    {
        return this.finished;
    }

    public String getText() {
        return this.raceText;
    }

    public int length() {
        return this.raceLength;
    }

    public void reset()
    {
        this.finished = false;
        this.racePos = 0;
    }

    public void readFile(String filename) {
        FileReader file;
        Scanner fileInput;
        StringBuilder text = new StringBuilder();

        try {
            file = new FileReader(filename);
            fileInput = new Scanner(file);

            while (fileInput.hasNext()) {
                text.append(fileInput.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        this.raceText = text.toString();
        this.raceLength = this.raceText.length();
    }

    public boolean next(String input)
    {
        int checkpoint;
        String substr;

        if(this.raceText.substring(racePos).contains(" "))
        {
            checkpoint = this.raceText.indexOf(" ", racePos) + 1;
            substr = this.raceText.substring(racePos, checkpoint);
        }
        else
        {
            checkpoint = this.raceLength - 1;
            substr = this.raceText.substring(racePos);
        }

        if(this.racePos == checkpoint)
        {
            this.finished = true;
            return true;
        }


        if(input.equals(substr))
        {
            this.racePos = checkpoint;
            return true;
        }
        else
        {
            return false;
        }
    }
}
