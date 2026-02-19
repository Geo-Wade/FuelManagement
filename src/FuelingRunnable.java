

public class FuelingRunnable implements Runnable {

    boolean stopRequested = false;
    @Override
    public void run() {
        while(!stopRequested){
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void requestStop(){
        stopRequested = true;
    }
}
