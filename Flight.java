import java.util.ArrayList;
import java.util.Scanner;
/**
This user-defined class will define a flight
Jeremy Odor
C21302913
 */
public class Flight
{
    private String flightNumber;
    private String day;
    private String destination;
    private int seatsBooked;

    /**
     * Constructor for objects of class Flight
     */
    public Flight()
    {
        this.flightNumber = " ";
        this.day = " ";
        this.destination = " ";
        this.seatsBooked = 0;
    }

    public Flight( String flightNumber, String day, String destination, int seatsBooked)
    {
        this.flightNumber = flightNumber;
        this.day = day;
        this.destination = destination;
        this.seatsBooked = seatsBooked;
    }

    public String getFlightNumber()
    {
        return this.flightNumber;
    }

    public String getDay()
    {
        return this.day;
    }

    public String getDestination()
    {
        return this.destination;
    }

    public int getSeatsBooked()
    {
        return this.seatsBooked;
    }

    public void setFlightNumber( String flightNumber)
    {
        this.flightNumber = flightNumber;
    }

    public void setDay (String day)
    {
        this.day = day;
    }

    public void setDestination ( String destination)
    {
        this.destination = destination;
    }

    public void setSeatsBooked ( int seatsBooked)
    {
        this.seatsBooked = seatsBooked;
    }

    public int getSeatsAvailible()
    {
        return 10 - this.seatsBooked;
    }

    public String toString()
    {
        return "The flight number is " + " " + this.flightNumber + "\n" +
        "The day that this flight will depart is" + " " + this.day + "\n" +
        "This flight will land in" + " " + this.destination + "\n" +
        "There are" + " " + this.seatsBooked + " " + "seats booked for this flight" +
        "\nThere are " + " "+ getSeatsAvailible() + " " + "seats availible"; 

    }

}
