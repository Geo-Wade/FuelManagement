import java.util.Optional;

public class FuelingCommandFactory implements ICommandFactory{
    public Optional<ICommand> commandFactory(int input){
        switch (input){
            case 1 ->{
                return Optional.of(new StartFuelingCommand());
            }
            case 2 ->{
                return Optional.of(new StopFuelingCommand());
            }
            default -> {
                return Optional.empty();
            }
        }
    }
}
