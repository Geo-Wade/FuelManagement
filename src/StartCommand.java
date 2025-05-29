import java.util.Optional;

public class StartCommand implements ICommand {
    public void execute(ConsoleIO consoleIO) {
        while(true) {
            Optional<ICommand> command = Optional.empty();
            while (command.isEmpty()) {
                ICommandFactory commandFactory = new StartCommandFactory();
                command = commandFactory.commandFactory(consoleIO.getIntInput("""
                        1) Fueling\t2) Add Record
                        """));
            }
            command.orElseThrow().execute(consoleIO);
        }
    }
}

