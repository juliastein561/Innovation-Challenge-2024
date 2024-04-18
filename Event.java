import java.util.ArrayList;

public class Event {
    private String eventName;
    private static String supplyShift;
    private static String demandShift;

    // default constructor ///////////////////////////////////
    public Event(){
        setEventName("");
        setSupplyShift("");
        setDemandShift("");
    }

    // custom constructors //////////////////////////////////

    // Where there is both a supply and demand shift
    public Event(String eventName, String supplyShift, String demandShift){
        setEventName(eventName);
        setSupplyShift(supplyShift);
        setDemandShift(demandShift);
    }

    /*// Where there is only a supply shift
    public Event(String eventName, String supplyShift){
        setEventName(eventName);
        setSupplyShift(supplyShift);
    }

    // Where there is only a demand shift
    public Event(String eventName, String demandShift, int overridingInt){
        setEventName(eventName);
        setDemandShift(demandShift);
        overridingInt = 0; // there is a same amount of strings as the supply shift,
                            // I have to include this to make it an overriding method.
    }*/

    // setters and getters for eventName, supplyShift, and demandShift;
    public void setEventName(String eventName){this.eventName = eventName; } public String getEventName(){return eventName;}
    public void setSupplyShift(String supplyShift){this.supplyShift = supplyShift;} public static String getSupplyShift(){return supplyShift;}
    public void setDemandShift(String demandShift) {this.demandShift = demandShift; } public static String getDemandShift(){return demandShift;}
}
