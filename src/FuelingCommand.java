import java.util.Optional;

public class FuelingCommand implements ICommand{
    public void execute(ConsoleIO consoleIO){
        Optional<ICommand> command = Optional.empty();
        FuelingCommandFactory fuelingCommandFactory = new FuelingCommandFactory();
        while(command.isEmpty())
        {
            command = fuelingCommandFactory.commandFactory(consoleIO.getIntInput("""
                    Please select one of the options
                    1) Start Fueling\t2) Stop Fueling"""));
        }
        command.orElseThrow().execute(consoleIO);
    }
}
