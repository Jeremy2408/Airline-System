
/**
This user-defined class will define a passenger
Jeremy Odor
C21302913
 */
public class Passenger
{
    private String passengerName;
    private String passengerAddress;
    private String passengerEmailAddress;
    
    private Flight flightAddress;
    /**
     * Constructor for objects of class Passenger
     */
    public Passenger()
    {
        this.passengerName = " ";
        this.passengerAddress = " ";
        this.passengerEmailAddress = " ";
        this.flightAddress = null;
    }

    public Passenger(String name,String address,String emailAddress)
    {
        this.passengerName = name;
        this.passengerAddress = address; 
        this.passengerEmailAddress = emailAddress;
        this.flightAddress = null;
    }

    public Passenger(String name,String address,String emailAddress,Flight flightNum)
    {
        this.passengerName = name;
        this.passengerAddress = address; 
        this.flightAddress = flightNum;
    }

    public String getPassengerName()
    {
        return this.passengerName;
    }

    public String getPassengerAddress()
    {
        return this.passengerAddress;
    }

    public String getPassengerEmailAddress()
    {
        return this.passengerEmailAddress;
    }
    
    public Flight getflightAddress()
    {
        return this.flightAddress;
    }
    
    public Flight getFlightNumber()
    {
        return this.flightAddress;
    }

    public void setPassengerName(String name)
    {
        this.passengerName = name;
    }

    public void setPassengerAddress(String address)
    {
        this.passengerAddress = address;
    }

    public void setPassengerEmailAddress(String emailAddress)
    {
        this.passengerEmailAddress = emailAddress;
    }
    
    
    public void setflightAddress(Flight flightNum)
    {
        this.flightAddress = flightNum;
    }
    
    public String toString()
    {
        String details=null;
        details = "\n\nPassenger Name: " + this.passengerName + "\n" +
        "Passenger Address: " + this.passengerAddress + "\n" +
        "Passenger Email Address: " + this.passengerEmailAddress + "\n";
        
        if (this.flightAddress==null)
        {
            details = details + "This person does not have a flight booked\n";
        }
        else
        {
            details = details + this.flightAddress.toString() + "\n\n";
        }
        
        return details;
    }
}