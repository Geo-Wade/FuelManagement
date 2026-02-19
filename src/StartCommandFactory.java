import java.util.Optional;

public class StartCommandFactory implements ICommandFactory {
    public Optional<ICommand> commandFactory(int input){
        switch (input){
            case 1 -> {
                return  Optional.of(new FuelingCommand());
            }
            case 2 ->{
                return  Optional.of(new AddRecordCommand());
            }
            default -> {
                return Optional.empty();
            }
        }
    }
}
