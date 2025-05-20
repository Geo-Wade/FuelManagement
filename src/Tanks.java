import java.util.HashSet;
import java.util.Optional;

public class Tanks {
    private static HashSet<TankRecord> tanks;

    private Tanks(){}

    public static HashSet<TankRecord> getTanks(){
        createIfNull();
        return tanks;
    }
    public static boolean add(TankRecord tank) {
        createIfNull();
        if(tank.getRecordField().values().stream().noneMatch(Optional::isEmpty)){
            tanks.add(tank);
            return true;
        }
        return false;
    }
    private static void createIfNull(){
        if(tanks == null){
            tanks = new HashSet<>();
        }
    }
}
