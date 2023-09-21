/**
 * This is a driver for the Flight class and Passenger class
 * Jeremy Odor
 * C21302913
 */

import java.util.Scanner;
import java.util.ArrayList;


public class AirlineDriver
{    
    //** Declare an arrayList*/
    ArrayList<Flight> flights;
    final int NUMBER_FLIGHTS = 5;

    ArrayList<Passenger> passengers;

    public AirlineDriver () {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");

        // Create a blank Passenger ArrayList
        passengers = new ArrayList<Passenger>();

        // Create the Flight ArrayList with 5 flights
        flights = new ArrayList<Flight>();
        createFlights();

        flightMenu();

    }

    public void createFlights()
    {
        Scanner scan = new Scanner(System.in);
        Flight aFlight;
        String flightNumber;
        String dayOfWeek;
        String destination;
        int seatsBooked;
        final int MINIMUM_UPPERCASE=2;
        final int MINIMUM_DIGITS=3;

        int uppercaseCounter=0;
        int digitCounter=0;
        boolean correct = true;

        System.out.println("\nCreate " + " " + NUMBER_FLIGHTS + " " + "flights.....");
        //Validation to ensure that the flight number begins with "EI"
        for (int count=0;count < NUMBER_FLIGHTS; count++ )
        {
            do {
                System.out.println("Enter the flight number \n");
                flightNumber = scan.nextLine();

                for (int i=0; i < flightNumber.length(); i++ ) {
                    Character c = flightNumber.charAt(i);
                    if(i == 0 && c.isUpperCase('E' )) 
                        uppercaseCounter++;
                    else if(i==1 && c.isUpperCase('I'))
                        uppercaseCounter++;

                    else if((i==2 || i==3 || i==4) && Character.isDigit(c)) 
                        digitCounter++;
                }

                if (uppercaseCounter== MINIMUM_UPPERCASE  &&  digitCounter == MINIMUM_DIGITS) { 
                    System.out.println("Flight Number Entered");
                }

                else
                {
                    correct = false;
                    System.out.println("Your flight number does not contain the following:");
                    if(uppercaseCounter < MINIMUM_UPPERCASE)
                        System.out.println(" At least 2 uppercase letters that begin with 'EI'");
                    if (digitCounter < MINIMUM_DIGITS) 
                        System.out.println("At least 3 digits");
                }
            }while (!correct);

            System.out.println("Enter the day of the week you wish for the flight to travel :\n");
            dayOfWeek = inputDay();

            System.out.println("Enter the destination of the flight :\n");
            destination= scan.nextLine();

            aFlight = new Flight(flightNumber,dayOfWeek,destination,0);
            flights.add(aFlight);
        }

        /*flightList = new Flight("EI115","Wednesday","Berlin",0);
        flights.add(flightList);

        flightList = new Flight("EI419","Friday","Lagos",0);
        flights.add(flightList);

        flightList = new Flight("EI505","Monday","London",0);
        flights.add(flightList);

        flightList = new Flight("EI717","Saturday","Lisbon",0);
        flights.add(flightList);

        flightList = new Flight("EI903","Thursday","Madrid",0);
        flights.add(flightList);
        System.out.println("\n" + NUMBER_FLIGHTS + " programmes created.");*/
        //Note: The "0" means that there are no seats booked//

    }

    public String inputDay()
    {
        Scanner scan = new Scanner(System.in);
        String day;

        do
        {
            //1. Ask user to input a day

            day = scan.nextLine();
             
            //Display an error message if the code entered isn't a day of the week 
            if(!day.equalsIgnoreCase("Monday") && !day.equalsIgnoreCase("Tuesday") && !day.equalsIgnoreCase("Wednesday") && !day.equalsIgnoreCase("Thursday") && !day.equalsIgnoreCase("Friday") && !day.equalsIgnoreCase("Saturday") &&  !day.equalsIgnoreCase("Sunday"))
            {
                System.out.println("Invalid Day of the Week!!!:");
            }

        }while (!day.equalsIgnoreCase("Monday") && !day.equalsIgnoreCase("Tuesday") && !day.equalsIgnoreCase("Wednesday") && !day.equalsIgnoreCase("Thursday") && !day.equalsIgnoreCase("Friday") && !day.equalsIgnoreCase("Saturday") &&  !day.equalsIgnoreCase("Sunday"));

        return day;
    }

    public void flightMenu()
    {
        Scanner scan = new Scanner(System.in);
        int menuOption;
        do {
            System.out.print("\f");
            System.out.println("1. Book a Flight");
            System.out.println("2. Cancel a Booking");
            System.out.println("3. Display Flight Schedule");
            System.out.println("4. Display Passenger Bookings");
            System.out.println("5. Covid Documentation ");
            System.out.println("6. Exit System");

            System.out.print("Which option would you like to proceed with?: ");
            menuOption = scan.nextInt();
            scan.nextLine();

            if (menuOption ==1)
            {
                createBooking();
            }
            else if (menuOption ==2)
            {
                cancelBooking();
            }
            else if (menuOption ==3)
            {
                displayFlights();
            }
            else if (menuOption ==4)
            {
                displayPassengerInfo();
            }
            else if (menuOption ==5)
            {
                covidDocumentation();
            }
        }while (menuOption !=6);
        scan.nextLine();
    } 

    public void createBooking()
    {
        String name, address, emailAddress, flightNumber;
        Passenger passenger1;
        Flight location;
        Scanner scan = new Scanner(System.in);
        int seats = 0;

        System.out.println("\n Creating passengers....");

        //1.Input Passenger details /
        System.out.println("\nEnter Passenger name :");
        name = scan.nextLine();
        System.out.println("\nEnter Passenger address :");
        address = scan.nextLine();
        System.out.println("\nEnter Passenger email address :");
        emailAddress = scan.nextLine();

        //2. Create a Passenger object
        passenger1 = new Passenger(name, address, emailAddress);

        System.out.println("\nEnter the Flight Number for the flight you wish to board");
        flightNumber= scan.nextLine();

        location = getFlightLocation(flightNumber);
        if ( location == null)
        {
            System.out.println("There is no such flight that exists in our system"); 
        }
        else
        {
            if (location.getSeatsBooked() >= 10)
            {
                System.out.println (" Flight is full");
            }
            else
            {
                passenger1.setflightAddress(location);
                System.out.println("Passenger has successfully booked flight");
                seats = location.getSeatsBooked();
                seats++;
                //Increments the seats by 1
                location.setSeatsBooked(seats);
                System.out.println("There are now " + location.getSeatsAvailible() + " seats availible");
                passengers.add(passenger1);
  
            }
        }

    }

    public Flight getFlightLocation(String flightNumber)
    {
        Flight location=null;

        for (Flight f: flights )
        {
            if (flightNumber.equalsIgnoreCase(f.getFlightNumber()))
            {
                location = f;
            }
        }

        return location;
    }

    public void cancelBooking()
    {

        String name,flightNumber;
        Scanner scan = new Scanner(System.in);
        Flight location;
        int seats;

        System.out.println("\n Booking cancellation in progress");
        //1.Input Passenger details /
        System.out.println("\nEnter Passenger name :");
        name = scan.nextLine();
        System.out.println("\nEnter Passenger flight number :");
        flightNumber = scan.nextLine();

        for (Passenger p: passengers)
        {
            if(p.getPassengerName().equals(name) && p.getflightAddress().getFlightNumber().equals(flightNumber))
            {
                System.out.println("Passenger has successfully cancelled flight");
                seats = p.getflightAddress().getSeatsBooked();
                seats--;
                //Decrements the seats by 1
                p.getflightAddress().setSeatsBooked(seats);
                
                System.out.println("There are now " + p.getflightAddress().getSeatsAvailible() + " seats availible");
                p.setflightAddress(null);
            }
        }

    }

    public void displayFlights()
    {
        System.out.println("\n\nDisplaying flight details....");

        //int location;
        for (Flight f: flights)  
        {
            System.out.println(f.toString());
        }

    }

    public void displayPassengerInfo()
    {
        System.out.println("\n\nDisplaying passenger information....");

        int location;
        for (Passenger p: passengers)
        {
            System.out.println(p.toString());
        }
    }

    public void covidDocumentation() 
    {
        Scanner scan = new Scanner(System.in);
        String name,dob;
        String vaccineDate1,vaccineDate2;
        String vaccineManufacturer;

        System.out.println("Enter name :");
        name = scan.nextLine();

        System.out.println("Enter date of birth :");
        dob = scan.nextLine();

        System.out.println("Enter date of first vaccine received:");
        vaccineDate1 = scan.nextLine();

        System.out.println("Enter date of second vaccine received :");
        vaccineDate2 = scan.nextLine();

        System.out.println("Enter the name of the vaccine you have received");

        do
        {
            vaccineManufacturer = scan.nextLine();
            //Validation to ensure that only the vaccine types listed below can be entered
            if(!vaccineManufacturer.equalsIgnoreCase("Pfizer") && !vaccineManufacturer.equalsIgnoreCase("Moderna") && !vaccineManufacturer.equalsIgnoreCase("AstraZenaca") && !vaccineManufacturer.equalsIgnoreCase("Novavax"))
            {
                System.out.println("Error-Vaccine not found");
            }
            

        }while (!vaccineManufacturer.equalsIgnoreCase("Pfizer") && !vaccineManufacturer.equalsIgnoreCase("Moderna") && !vaccineManufacturer.equalsIgnoreCase("AstraZenaca") && !vaccineManufacturer.equalsIgnoreCase("Novavax"));
        
        System.out.print("\n\nPassenger Name : " + name + "\n" +
        "Passenger Date of Birth : " + dob + "\n" +
        "Passenger First Vaccine Date : " + vaccineDate1 + "\n" +
        "Passenger Second Vaccine Date :" + vaccineDate2 + "\n" +
        "Vaccine Name : " + vaccineManufacturer);
    }
}
        
        
        
        

    


