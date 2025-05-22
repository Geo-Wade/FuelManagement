import java.util.HashSet;

public class Tanks {
    private final static HashSet<TankRecord> tanks = new HashSet<>();

    private Tanks(){}

    public static HashSet<TankRecord> getTanks(){
        return tanks;
    }
    public static boolean add(TankRecord tank) {
        if(!isDuplicate(tank)){
            tanks.add(tank);
            return true;
        }
        return false;
    }
    private static boolean isDuplicate(TankRecord tank){
        return tanks.stream()
                .map(TankRecord::getTankID)
                .anyMatch(id -> id.equals(tank.getTankID()));
    }
}
