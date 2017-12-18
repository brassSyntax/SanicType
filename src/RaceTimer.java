import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

public class RaceTimer extends JLabel {

    private Timer timer;
    private long lastTick;
    private long seconds;
    private JLabel clockLabel;

    private static final int CLOCK_REFRESH_RATE = 20;

    public RaceTimer() {
        clockLabel = this;
        clockLabel.setText(String.format("%01d:%02d.%02d", 0, 0, 0));

        timer = new Timer(CLOCK_REFRESH_RATE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long runTime = System.currentTimeMillis() - lastTick;
                Duration duration = Duration.ofMillis(runTime);
                duration = duration.minusHours(duration.toHours());
                long minutes = duration.toMinutes();
                duration = duration.minusMinutes(minutes);
                long millis = duration.toMillis();
                seconds = millis / 1000; // seconds are separate because used in WpmCounter
                millis %= 1000;

                clockLabel.setText(String.format("%01d:%02d.%02d", minutes, seconds, millis));
            }
        });
    }

    public int getSeconds() {
        return (int) this.seconds;
    }

    public void setLastTick(long time) {
        this.lastTick = time;
    }

    public void start() {
        this.timer.start();
    }

    public void stop() {
        this.timer.stop();
    }

    public void restart() {
        this.timer.stop();
        this.seconds = 0;
        clockLabel.setText(String.format("%01d:%02d.%02d", 0, 0, 0));
    }

    public boolean isRunning() {
        return this.timer.isRunning();
    }
}
