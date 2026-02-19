public class Main {

    public static void main(String[] args) {
        FuelingManager.getFuelingManager().addFuelingPosition(new FuelingPosition("Hose 1"));
        FuelingManager.getFuelingManager().addFuelingPosition(new FuelingPosition("Hose 2"));
        FuelingManager.getFuelingManager().addFuelingPosition(new FuelingPosition("Hose 3"));
        FuelingManager.getFuelingManager().addFuelingPosition(new FuelingPosition("Hose 4"));
        FuelingManager.getFuelingManager().addFuelingPosition(new FuelingPosition("Hose 5"));

        ConsoleIO IO = new ConsoleIO();
        StartCommand startCommand = new StartCommand();
        startCommand.execute(IO);
    }
}