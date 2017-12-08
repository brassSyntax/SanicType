import java.io.FileReader;
import java.util.Scanner;

public class Race {

    private boolean finished;
    private String raceText;
    private int raceLength;
    private int racePos;

    public Race() {
        this.finished = false;
        this.setRaceText(null);
        this.raceLength = 0;
        this.racePos = 0;
    }

    public Race(String text) {
        this.finished = false;
        this.setRaceText(text);
        this.raceLength = text.length();
        this.racePos = 0;
    }

    public boolean isFinished()
    {
        return this.finished;
    }

    public String getRaceText() {
        return this.raceText;
    }

    public void setRaceText(String raceText) {
        this.raceText = raceText;
        this.raceLength = this.raceText.length();
    }

    public int length() {
        return this.raceLength;
    }

    public void reset()
    {
        this.finished = false;
        this.racePos = 0;
    }

    public boolean next(String input)
    {
        int checkpoint;
        String substr;

        if(this.getRaceText().substring(racePos).contains(" "))
        {
            checkpoint = this.getRaceText().indexOf(" ", racePos) + 1;
            substr = this.getRaceText().substring(racePos, checkpoint);
        }
        else
        {
            checkpoint = this.raceLength - 1;
            substr = this.getRaceText().substring(racePos);
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
