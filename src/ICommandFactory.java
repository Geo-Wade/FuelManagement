import java.util.Optional;

public interface ICommandFactory {
    Optional<ICommand> commandFactory(int input);
}
