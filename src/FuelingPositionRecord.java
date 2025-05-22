

/*public class FuelingPositionRecord extends Record{
    private String hoseID;
    private int hoseNumber;
    private TankRecord sourceTank;
    private int pulserDivideRate;

    final static String HOSE_ID_TOKEN = "Hose ID";
    final static String HOSE_NUMBER_TOKEN = "Hose Number";
    final static String SOURCE_TANK_TOKEN = "Source Tank";
    final static String DEVIDE_RATE_TOKEN = "Pulser Divide Rate";


    public FuelingPositionRecord()
    {
        recordFields = new LinkedHashMap<>();
        recordFields.put(HOSE_ID_TOKEN, Optional.empty());
        recordFields.put(HOSE_NUMBER_TOKEN,Optional.empty());
        recordFields.put(SOURCE_TANK_TOKEN,Optional.empty());
        recordFields.put(DEVIDE_RATE_TOKEN,Optional.empty());
    };

    public Map<String, Optional<String>> initRecord (){
        return recordFields;
    }
    @Override
    boolean assignRecord() {
        for(String key : recordFields.keySet())
        {
            switch (key){
                case HOSE_ID_TOKEN:
                    hoseID  = recordFields.get(key).orElse("Not Data Recorded");
                    break;
                case HOSE_NUMBER_TOKEN:
                {
                    if(isInt(recordFields.get(key).orElse("Not an int"))) {
                        hoseNumber = Integer.parseInt(recordFields.get(key).orElse("No Data Recorded"));
                    }
                    break;
                }
                case SOURCE_TANK_TOKEN:
                    //TODO - create logic for validating source tank
                    break;
                case DEVIDE_RATE_TOKEN:
                    if(isInt(recordFields.get(key).orElse("Not an int"))) {
                        hoseNumber = Integer.parseInt(recordFields.get(key).orElse("No Data Recorded"));
                    }
                    break;
                default:
                    System.out.println("Invalid Data Provided TO Record: " + key);
                    break;
            }
        }
        return recordFields.values().stream().filter(Optional::isEmpty).toList().isEmpty();
    }
    public String getHoseID()
    {
        return hoseID;
    }

    public int getHoseNumber()
    {
        return hoseNumber;
    }

    public TankRecord getSourceTank()
    {
        return sourceTank;
    }

    public int getpulserDivideRate()
    {
        return pulserDivideRate;
    }

    @Override
    public String toString()
    {
        return "Vehicle ID: " + getHoseID()
                + "\n"
                + "Vehicle Year: " + getHoseNumber()
                + "\n"
                + "Vehicle Make: " + getSourceTank()
                + "\n"
                + "Vehicle Model: " + getpulserDivideRate()
                + "\n";

    }
    private static boolean isInt(String string)
    {
        try{
            int x = Integer.parseInt(string);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }
}
*/