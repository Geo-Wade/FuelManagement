public class OdomService {
    //Needs to hold rules for new odometer entries
    //Implement static method for changing max travel distance
    private static Integer maxTravelDistance = 5000;

    public static Integer UpdateOdometer(Integer NewOdometer, Integer OldOdometer) {
        if (NewOdometer > OldOdometer && NewOdometer - OldOdometer <= maxTravelDistance) {
            return NewOdometer;
        } else {
            return OldOdometer;
        }
    }
}
