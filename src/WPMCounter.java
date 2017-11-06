import javax.swing.*;

public class WPMCounter extends JLabel{
    private int WPM; // TODO: improve for higher precision
    private int wordCount;

    public WPMCounter()
    {
        this.WPM = 0;
        this.wordCount = 0;
        this.setText("0");
    }

    public void increment()
    {
        this.wordCount++;
    }

    public void count(int seconds)
    {
        if(seconds != 0)
        {
            WPM = (wordCount * 60) / seconds;
        }

        this.setText(Integer.toString(this.WPM));
    }

    public void reset()
    {
        this.wordCount = 0;
        this.setText("0");
    }
}
