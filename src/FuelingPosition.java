import java.time.Duration;
import java.time.Instant;

public class FuelingPosition {
    private final String hoseID;
    private int hoseNumber;
    double quantityPerSecond = 1;
    Thread fueling;
    FuelingRunnable fuelingRunnable;
    Instant start;
    private boolean isFueling = false;

    FuelingPosition(String hoseID) {
        this.hoseID = hoseID;
    }

    public void start() {
        fuelingRunnable = new FuelingRunnable();
        fueling = new Thread(fuelingRunnable);
        start = Instant.now();
        fueling.start();
        isFueling = true;
    }

    //returns the total quantity pumped
    public double stop() {
        fuelingRunnable.requestStop();
        try {
            fueling.join();
            isFueling = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Duration.between(start, Instant.now()).toMillis() * quantityPerSecond / 1000;
    }

    public String getHoseID() {
        return hoseID;
    }

    public void setHoseNumber(int hoseNumber) {
        this.hoseNumber = hoseNumber;
    }

    public int getHoseNumber() {
        return hoseNumber;
    }

    public boolean isFueling() {
        return isFueling;
    }
}
