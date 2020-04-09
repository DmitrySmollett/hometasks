package JavaClassesMain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalTime.MIDNIGHT;

public class Train {
    int number;
    String destination;
    LocalTime departureTime;
    //    Плацкарт - Economy class sleeper. Купе - Compartment sleeper. Общие - Sitting coaches. Люкс - Business class
    int sittingCoaches;
    int economyClassSleeper;
    int compartmentSleeper;
    int businessClass;

    Train () {
        destination = "Default";
        departureTime = MIDNIGHT;
    }
    Train (String destination) {
        this.destination = destination;
        departureTime = MIDNIGHT;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setEconomyClassSleeper(int economyClassSleeper) {
        this.economyClassSleeper = economyClassSleeper;
    }

    public void setCompartmentSleeper(int compartmentSleeper) {
        this.compartmentSleeper = compartmentSleeper;
    }

    public void setSittingCoaches(int sittingCoaches) {
        this.sittingCoaches = sittingCoaches;
    }

    public void setBusinessClass(int businessClass) {
        this.businessClass = businessClass;
    }

    public int getNumber() {
        return number;
    }

    public String getDestination() {
        return destination;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public int getEconomyClassSleeper() {
        return economyClassSleeper;
    }

    public int getCompartmentSleeper() {
        return compartmentSleeper;
    }

    public int getSittingCoaches() {
        return sittingCoaches;
    }

    public int getBusinessClass() {
        return businessClass;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return "Train №" + number +
                ": Destination - " + destination +
                ", Departure - " + departureTime.format(formatter) +
                ", Tickets: Sitting Coaches " + sittingCoaches +
                ", Economy Class Sleeper - " + economyClassSleeper +
                ", Compartment Sleeper - " + compartmentSleeper +
                ", Business Class - " + businessClass;
    }
}
