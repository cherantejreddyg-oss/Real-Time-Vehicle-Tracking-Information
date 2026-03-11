package VehicleMonitoring;

public class Vehicle {

    String regNumber;
    double latitude;
    double longitude;
    String date;
    String time;

    public Vehicle(String regNumber, double latitude, double longitude, String date, String time) {
        this.regNumber = regNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return regNumber + " at [" + latitude + ", " + longitude + "] on " + date + " " + time;
    }
}